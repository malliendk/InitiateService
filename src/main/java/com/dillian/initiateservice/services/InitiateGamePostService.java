package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.InitiateDTO;
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

    public void initiateCalculationService(InitiateDTO initiateDTO) {
        log.info("outgoing supervisorID: " + initiateDTO.getSupervisor());
        log.info("Pushing to calculation service");
        log.info("Outgoing GameDTO: {}", initiateDTO);
        restClient
                .post()
                .uri(ServerURLs.CALCULATION_SERVICE_URL)
                .body(initiateDTO)
                .retrieve()
                .toEntity(InitiateDTO.class);
    }

    public void updateGameCalculationService(InitiateDTO updatedDTO) {
        log.info("Updating game DTO to calculation service: {}", updatedDTO);
        ResponseEntity<InitiateDTO> response = restClient
                .put()
                .uri(ServerURLs.CALCULATION_SERVICE_URL)
                .body(updatedDTO)
                .retrieve()
                .toEntity(InitiateDTO.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            log.info("Calculation Service successfully updated: {}", updatedDTO);
        }
    }
}
