package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.SupervisorDTO;
import com.dillian.initiateservice.util.BuildingIds;
import com.dillian.initiateservice.util.ServerURLs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class EntityRetrieveService {

    private final RestClient restClient;

    public SupervisorDTO getSupervisorDTO(Long supervisorId) {
        String url = ServerURLs.SUPERVISOR_SERVICE_URL + "/" + supervisorId;
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

    public Map<Long, Integer> getBuildings() {
        List<Long> ids = List.of(BuildingIds.TOWN_HALL, BuildingIds.COAL_PLANT, BuildingIds.GAS_PLANT,
                BuildingIds.TRANSFORMATOR_HUISJE, BuildingIds.TRANSFORMATOR_HUISJE, BuildingIds.TRANSFORMATOR_HUISJE,
                BuildingIds.HOOGSPANNINGS_STATIOM, BuildingIds.MIDDENSPANNINGS_STATION, BuildingIds.MIDDENSPANNINGS_STATION,
                BuildingIds.HOOGSPANNINGS_MAST, BuildingIds.ELECTRIC_PARKING_LOT, BuildingIds.VRIJSTAAND_HUIS);

        final ResponseEntity<Map<Long, Integer>> reponse = restClient
                .post()
                .uri(ServerURLs.BUILDING_SERVICE_URL + "/id-map")
                .body(ids)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {
                });
        return reponse.getBody();
    }
}
