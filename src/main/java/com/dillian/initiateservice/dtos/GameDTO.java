package com.dillian.initiateservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameDTO {

    private Long id;
    private SupervisorDTO supervisor;
    private List<BuildingDTO> buildings;
    private List<SolarPanelSetDTO> solarPanelSets;
}
