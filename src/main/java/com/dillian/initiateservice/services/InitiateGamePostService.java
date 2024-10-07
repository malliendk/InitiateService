package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.GameDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class InitiateGamePostService {

    private final WebClient webClient;
    private final RestClient restClient;

    public void initiateServicesAndSchedulers(GameDTO gameDTO) {
        startEventScheduler();
        startDayWeatherScheduler();
        pushToUpdateService(gameDTO);
        pushToBff(gameDTO);
    }


    public void startEventScheduler() {
        webClient.post()
                .uri("http://localhost:8081/event/scheduler/start")
                .retrieve()
                .toBodilessEntity()
                .doOnSuccess(response -> log.info("Event scheduler successfully started"))
                .doOnError(error -> log.error("Event scheduler failed to start", error))
                .block();
    }

    public void startDayWeatherScheduler() {
        webClient.post()
                .uri("http://localhost:8081/day-weather/start")
                .retrieve()
                .toBodilessEntity()
                .doOnSuccess(response -> log.info("Day weather scheduler successfully started"))
                .doOnError(error -> log.error("Day weather scheduler failed to start", error))
                .block();
    }

    public void pushToUpdateService(GameDTO gameDTO) {
        try {
            ResponseEntity<Void> response = restClient.post()
                    .uri("http://localhost:8082/game")
                    .body(gameDTO)
                    .retrieve()
                    .toBodilessEntity();
            if (response.getStatusCode().is2xxSuccessful()) {
                log.info("GameDTO successfully pushed to update service: {}", gameDTO);
            }
        } catch (Exception e) {
            log.error("Error pushing GameDTO to update service: {}", e.getMessage());
        }
    }

    public void pushToBff(GameDTO gameDTO) {
        ResponseEntity<GameDTO> response = ResponseEntity.ok(webClient.post()
                        .uri("http://localhost:8083/game")
                        .bodyValue(gameDTO)
                        .retrieve()
                        .bodyToMono(GameDTO.class)
                        .block());
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("GameDto successfully pushed to backend-for-frontend: {}", gameDTO);
        }
    }
}
