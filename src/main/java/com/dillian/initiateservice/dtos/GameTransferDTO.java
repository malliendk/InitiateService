package com.dillian.initiateservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class GameTransferDTO {

    private Long id;
//    private SupervisorDTO supervisor;
//    private List<BuildingDTO> buildings;
    private Map<Long, Integer> buildingIdSolarPanelMap;
    private int funds;
    private int popularity;
}
