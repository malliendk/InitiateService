package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.BuildingRequestDTO;
import com.dillian.initiateservice.dtos.District;
import com.dillian.initiateservice.dtos.InitiateDTO;
import com.dillian.initiateservice.dtos.Tile;
import com.dillian.initiateservice.util.BuildingIds;
import com.dillian.initiateservice.util.StartingValues;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InitiateDTOBuilderService {

    public InitiateDTO assembleInitiateDTO() {
        InitiateDTO initialInitiateDTO = new InitiateDTO();
        initialInitiateDTO.setId(1L);
        initialInitiateDTO.setFunds(StartingValues.FUNDS_STARTING_AMOUNT);
        initialInitiateDTO.setPopularity(StartingValues.POPULARITY_STARTING_AMOUNT);
        initialInitiateDTO.setBuildingRequests(selectStartingBuildings());
        final List<Tile> startingTiles = createStartingTiles();
        initialInitiateDTO.setTiles(startingTiles);
        initialInitiateDTO.setDistricts(createStartingDistricts(startingTiles));
        return initialInitiateDTO;
    }

    private List<BuildingRequestDTO> selectStartingBuildings() {
        return List.of(
                new BuildingRequestDTO(BuildingIds.TRANSFORMATOR_HUISJE, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.TRANSFORMATOR_HUISJE, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.TRANSFORMATOR_HUISJE, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.MIDDENSPANNINGS_STATION, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.MIDDENSPANNINGS_STATION, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.HOOGSPANNINGS_STATION, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.HOOGSPANNINGS_MAST, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.VRIJSTAAND_HUIS, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.VRIJSTAAND_HUIS, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.TOWN_HALL, 100, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.COAL_PLANT, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.GAS_PLANT, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.ELECTRIC_PARKING_LOT, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.INDUSTRIAL_AREA, 0, new HashMap<>()),
                new BuildingRequestDTO(BuildingIds.INDUSTRIAL_AREA, 0, new HashMap<>())
        );
    }

    private List<District> createStartingDistricts(List<Tile> tiles) {
        District district1 = new District();
        district1.setId(1L);
        district1.setTiles(new ArrayList<>());
        District district2 = new District();
        district2.setId(2L);
        district2.setTiles(new ArrayList<>());
        District district3 = new District();
        district3.setId(3L);
        district3.setTiles(new ArrayList<>());
        District district4 = new District();
        district4.setId(4L);
        district4.setTiles(new ArrayList<>());

        for (Tile tile : tiles) {
            if (tile.getDistrictId() == 1L) {
                district1.getTiles().add(tile);
            } else if (tile.getDistrictId() == 2L) {
                district2.getTiles().add(tile);
            } else if (tile.getDistrictId() == 3L) {
                district3.getTiles().add(tile);
            } else if (tile.getDistrictId() == 4L) {
                district4.getTiles().add(tile);
            }
        }

        return List.of(district1, district2, district3, district4);
    }


    private List<Tile> createStartingTiles() {
        return List.of(
                new Tile(1L, BuildingIds.TRANSFORMATOR_HUISJE, 1L),
                new Tile(2L, BuildingIds.VRIJSTAAND_HUIS, 1L),
                new Tile(3L, BuildingIds.VRIJSTAAND_HUIS, 1L),
                new Tile(4L, null, 1L),
                new Tile(5L, null, 1L),
                new Tile(6L, null, 1L),
                new Tile(7L, BuildingIds.TRANSFORMATOR_HUISJE, 1L),
                new Tile(8L, null, 1L),
                new Tile(9L, null, 1L),
                new Tile(10L, null, 1L),
                new Tile(11L, null, 1L),
                new Tile(12L, null, 1L),
                new Tile(13L, BuildingIds.TRANSFORMATOR_HUISJE, 2L),
                new Tile(14L, BuildingIds.MIDDENSPANNINGS_STATION, 2L),
                new Tile(15L, null, 2L),
                new Tile(16L, null, 2L),
                new Tile(17L, null, 2L),
                new Tile(18L, BuildingIds.TOWN_HALL, 2L),
                new Tile(19L, BuildingIds.ELECTRIC_PARKING_LOT, 2L),
                new Tile(20L, null, 2L),
                new Tile(21L, null, 2L),
                new Tile(22L, null, 2L),
                new Tile(23L, null, 2L),
                new Tile(24L, null, 2L),
                new Tile(25L, BuildingIds.MIDDENSPANNINGS_STATION, 2L),
                new Tile(26L, null, 2L),
                new Tile(27L, null, 2L),
                new Tile(28L, null, 2L),
                new Tile(29L, null, 2L),
                new Tile(30L, null, 2L),
                new Tile(31L, BuildingIds.HOOGSPANNINGS_STATION, 4L),
                new Tile(32L, null, 4L),
                new Tile(33L, null, 4L),
                new Tile(34L, null, 4L),
                new Tile(35L, null, 3L),
                new Tile(36L, null, 3L),
                new Tile(37L, BuildingIds.COAL_PLANT, 4L),
                new Tile(38L, BuildingIds.GAS_PLANT, 4L),
                new Tile(39L, BuildingIds.INDUSTRIAL_AREA, 4L),
                new Tile(40L, BuildingIds.HOOGSPANNINGS_MAST, 4L),
                new Tile(41L, null, 4L),
                new Tile(42L, null, 4L),
                new Tile(43L, null, 4L),
                new Tile(44L, null, 4L),
                new Tile(45L, BuildingIds.INDUSTRIAL_AREA, 4L),
                new Tile(46L, null, 4L),
                new Tile(47L, null, 4L),
                new Tile(48L, null, 4L)
        );
    }
}
