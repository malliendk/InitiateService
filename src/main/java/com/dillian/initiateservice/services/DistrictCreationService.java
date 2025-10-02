package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.BuildingRequestDTO;
import com.dillian.initiateservice.dtos.District;
import com.dillian.initiateservice.dtos.InitiateDTO;
import com.dillian.initiateservice.dtos.Tile;
import com.dillian.initiateservice.util.BuildingIds;
import com.dillian.initiateservice.util.StartingValues;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class DistrictCreationService {

    public InitiateDTO createNewDistrict(InitiateDTO initiateDTO) {
        District newDistrict = new District();
        newDistrict.setId(initiateDTO.getDistricts().size() + 1L);
        newDistrict.setTiles(createEmptyTiles(newDistrict.getId()));
        initiateDTO.getDistricts().add(newDistrict);
        return initiateDTO;
    }

    private List<Tile> createEmptyTiles(Long districtId) {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 1; i < StartingValues.STARTING_TILE_AMOUNT_PER_DISTRICT; i++) {
            Tile tile = new Tile();
            tile.setId((long) i);
            tile.setBuildingId(null);
            tile.setDistrictId(districtId);
            emptyTiles.add(tile);
        }
        return emptyTiles;
    }

    public List<BuildingRequestDTO> selectStartingBuildings() {
        return List.of(
                new BuildingRequestDTO(BuildingIds.TRANSFORMATOR_HUISJE, 0, 0, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.TRANSFORMATOR_HUISJE, 0, 0, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.TRANSFORMATOR_HUISJE, 0, 0, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.MIDDENSPANNINGS_STATION, 0, 0, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.MIDDENSPANNINGS_STATION, 0, 0, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.HOOGSPANNINGS_STATION, 0, 0, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.HOOGSPANNINGS_MAST, 0, 0, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.VRIJSTAAND_HUIS, 2, 10, 4, 2, 2, 0),
                new BuildingRequestDTO(BuildingIds.VRIJSTAAND_HUIS, 2, 10, 4, 2, 2, 0),
                new BuildingRequestDTO(BuildingIds.TOWN_HALL, 25, 125, 25, 0, 25, 25),
                new BuildingRequestDTO(BuildingIds.COAL_PLANT, 0, 5000, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.GAS_PLANT, 0, 5000, 0, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.ELECTRIC_PARKING_LOT, 0, 0, 18, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.INDUSTRIAL_AREA, 0, 0, 56, 0, 0, 0),
                new BuildingRequestDTO(BuildingIds.INDUSTRIAL_AREA, 0, 0, 56, 0, 0, 0)
        );
    }

    public List<Tile> generateStartingTiles() {
        List<Tile> tiles = new ArrayList<>();
        int tilesPerDistrict = StartingValues.STARTING_TILE_AMOUNT_PER_DISTRICT;
        int numberOfDistricts = StartingValues.STARTING_NUMBER_OF_DISTRICTS;

        long tileId = 1;
        for (int districtId = 1; districtId <= numberOfDistricts; districtId++) {
            for (int i = 0; i < tilesPerDistrict; i++) {
                Tile tile = new Tile();
                tile.setId(tileId++);
                tile.setDistrictId((long) districtId);
                tile.setBuildingId(null);
                tiles.add(tile);
            }
        }

        log.info("Generated {} tiles across {} districts ({} per district)", tiles.size(), numberOfDistricts, tilesPerDistrict);
        return tiles;
    }

    public void assignBuildingsToTiles(List<Tile> tiles) {
        Map<Long, Long> buildingAssignments = Map.ofEntries(
                Map.entry(1L, BuildingIds.COAL_PLANT),
                Map.entry(2L, BuildingIds.HOOGSPANNINGS_STATION),
                Map.entry(3L, BuildingIds.HOOGSPANNINGS_MAST),
                Map.entry(4L, BuildingIds.TRANSFORMATOR_HUISJE),
                Map.entry(7L, BuildingIds.TRANSFORMATOR_HUISJE),
                Map.entry(21L, BuildingIds.TRANSFORMATOR_HUISJE),
                Map.entry(22L, BuildingIds.MIDDENSPANNINGS_STATION),
                Map.entry(25L, BuildingIds.TOWN_HALL),
                Map.entry(29L, BuildingIds.ELECTRIC_PARKING_LOT),
                Map.entry(34L, BuildingIds.MIDDENSPANNINGS_STATION),
                Map.entry(41L, BuildingIds.VRIJSTAAND_HUIS),
                Map.entry(42L, BuildingIds.VRIJSTAAND_HUIS),
                Map.entry(43L, BuildingIds.MIDDENSPANNINGS_STATION),
                Map.entry(61L, BuildingIds.GAS_PLANT),
                Map.entry(62L, BuildingIds.HOOGSPANNINGS_STATION),
                Map.entry(63L, BuildingIds.HOOGSPANNINGS_MAST),
                Map.entry(70L, BuildingIds.INDUSTRIAL_AREA),
                Map.entry(71L, BuildingIds.INDUSTRIAL_AREA)
                );
        buildingAssignments.forEach((tileId, buildingId) ->
                tiles.stream()
                        .filter(tile -> tile.getId().equals(tileId))
                        .findFirst()
                        .ifPresent(tile -> tile.setBuildingId(buildingId))
        );
    }

    public List<District> groupTilesIntoDistricts(List<Tile> tiles) {
        Map<Long, District> districtMap = new HashMap<>();
        for (long i = 1; i <= StartingValues.STARTING_NUMBER_OF_DISTRICTS; i++) {
            District district = new District();
            district.setId(i);
            district.setTiles(new ArrayList<>());
            districtMap.put(i, district);
        }
        for (Tile tile : tiles) {
            District district = districtMap.get(tile.getDistrictId());
            if (district != null) {
                district.getTiles().add(tile);
            }
        }
        return new ArrayList<>(districtMap.values());
    }

    private boolean placeBuildingInRandomTile(Long buildingId, Long districtId, List<Tile> tiles) {
        List<Tile> availableTiles = tiles.stream()
                .filter(tile -> tile.getDistrictId().equals(districtId) && tile.getBuildingId() == null)
                .toList();

        if (availableTiles.isEmpty()) {
            log.warn("No available tiles found in district {} to place building {}", districtId, buildingId);
            return false;
        }

        Tile selectedTile = availableTiles.get(new Random().nextInt(availableTiles.size()));
        selectedTile.setBuildingId(buildingId);
        log.info("Placed building {} on tile {} in district {}", buildingId, selectedTile.getId(), districtId);
        return true;
    }

}
