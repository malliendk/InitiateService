package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.*;
import com.dillian.initiateservice.util.Constants;
import com.dillian.initiateservice.util.ServerURLs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class EntityRetrieveService {

    private final RestClient restClient;

    public SupervisorDTO getSupervisorDTO(InitiateDTO initDto) {
        String url = "http://localhost:8091/supervisor/" + initDto.getSupervisorId();
        ResponseEntity<SupervisorDTO> response = restClient
                .get()
                .uri(url)
                .retrieve()
                .toEntity(SupervisorDTO.class);
        log.info(url);
        SupervisorDTO supervisor = response.getBody();
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("GET Supervisor Service call successfully made");
        }
        if (supervisor != null) {
            log.info("Supervisor successfully retrieved: {}", supervisor);
        }
        return supervisor;
    }

    public List<BuildingDTO> getBuildings() {
        String ids = Stream.of(Constants.TOWN_HALL_ID, Constants.COAL_PLANT_ID)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        String url = ServerURLs.BUILDING_SERVICE_URL + "/building?ids=" + ids;
        ResponseEntity<List<BuildingDTO>> response = restClient
                .get()
                .uri(url)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {
                });
        List<BuildingDTO> retrievedList = response.getBody();
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("GET BuildingService Buildings call successfully made");
        }
        if (retrievedList != null && retrievedList.size() == 2) {
            log.info("successfully retrieved 2 buildings: {}", retrievedList);
            retrievedList = retrievedList
                    .stream()
                    .sorted(Comparator.comparing(BuildingDTO::getId))
                    .toList();
        }
        return retrievedList;
    }
}
