package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.GameDTO;
import com.dillian.initiateservice.util.ServerURLs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
@Slf4j
public class InitiateGamePostService {

    private final RestClient restClient;

    public void initiateServicesAndSchedulers(GameDTO initiateGameDTO) {
        pushToUpdateService(initiateGameDTO);
        pushToBff(initiateGameDTO);
        startEventScheduler();
    }

    public void startEventScheduler() {
        ResponseEntity<Void> response = restClient
                .post()
                .uri(ServerURLs.BUILDING_SERVICE_URL + "/scheduler/start")
                .retrieve()
                .toBodilessEntity();
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Event scheduler successfully started");
        }
    }

    public void pushToUpdateService(GameDTO initiateDTO) {
        ResponseEntity<GameDTO> response = restClient
                .post()
                .uri(ServerURLs.UPDATE_SERVICE_URL + "/game/start")
                .body(initiateDTO)
                .retrieve()
                .toEntity(GameDTO.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("GameDTO successfully pushed to update service: {}", initiateDTO);
        }
    }

    public void pushToBff(GameDTO initiateDTO) {
        ResponseEntity<GameDTO> response = restClient
                .post()
                .uri(ServerURLs.BACKEND_FOR_FRONTEND_URL + "/game/start")
                .body(initiateDTO)
                .retrieve()
                .toEntity(GameDTO.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("GameDto successfully pushed to backend-for-frontend: {}", initiateDTO);
        }
    }
}
