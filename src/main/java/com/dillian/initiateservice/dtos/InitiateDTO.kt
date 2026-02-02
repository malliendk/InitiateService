package com.dillian.initiateservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class InitiateDTO {

    private Long id;
    private SupervisorDTO supervisor;
    private List<BuildingRequestDTO> buildingRequests;
    private List<Tile> tiles;
    private List<District> districts;
    private int funds;
    private int popularity;
    private int research;
    private int environmentalScore;
}
