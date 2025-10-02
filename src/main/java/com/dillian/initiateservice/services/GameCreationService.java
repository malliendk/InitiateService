package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.*;
import com.dillian.initiateservice.util.BuildingIds;
import com.dillian.initiateservice.util.StartingValues;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class GameCreationService {

    private final DistrictCreationService districtCreationService;

    public InitiateDTO assembleInitiateDTO(SupervisorDTO supervisor) {
        InitiateDTO dto = new InitiateDTO();
        dto.setId(1L);
        dto.setFunds(StartingValues.FUNDS_STARTING_AMOUNT);
        dto.setPopularity(StartingValues.POPULARITY_STARTING_AMOUNT);
        dto.setResearch(StartingValues.RESEARCH_STARTING_AMOUNT);
        dto.setBuildingRequests(districtCreationService.selectStartingBuildings());
        dto.setSupervisor(supervisor);
        List<Tile> tiles = districtCreationService.generateStartingTiles();
        districtCreationService.assignBuildingsToTiles(tiles);
        dto.setTiles(tiles);
        dto.setDistricts(districtCreationService.groupTilesIntoDistricts(tiles));
        return dto;
    }
}
