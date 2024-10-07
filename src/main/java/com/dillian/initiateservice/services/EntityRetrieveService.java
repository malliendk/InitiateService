package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.BuildingDTO;
import com.dillian.initiateservice.dtos.InitiateGameDTO;
import com.dillian.initiateservice.dtos.SolarPanelSetDTO;
import com.dillian.initiateservice.dtos.SupervisorDTO;
import com.dillian.initiateservice.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class EntityRetrieveService {

    private final RestClient restClient;


    public SupervisorDTO getSupervisorDTO(InitiateGameDTO initDto) {
        String supervisorFullName = initDto.getSupervisorFirstName() + initDto.getSupervisorLastName();
        return restClient
                .get()
                .uri("supervisor", supervisorFullName)
                .retrieve()
                .toEntity(SupervisorDTO.class)
                .getBody();
    }

    public List<SolarPanelSetDTO> getSolarPanels() {
        return restClient
                .get()
                .uri("solar-panel", 100)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<SolarPanelSetDTO>>() {})
                .getBody();
    }

    public List<BuildingDTO> getBuildings() {
        String ids = Stream.of(Constants.TOWN_HALL_ID, Constants.COAL_PLANT_ID)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return restClient
                .get()
                .uri("/building?ids=", ids)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<BuildingDTO>>() {})
                .getBody();
    }
}
