package com.dillian.initiateservice.services

import com.dillian.initiateservice.dtos.BuildingRequestDTO
import com.dillian.initiateservice.dtos.InitiateDTO
import com.dillian.initiateservice.dtos.SupervisorDTO
import com.dillian.initiateservice.dtos.Tile
import com.dillian.initiateservice.util.*
import org.springframework.stereotype.Service

@Service
class GameCreationService {

    fun assembleInitiateDTO(supervisor: SupervisorDTO): InitiateDTO {
        val dto = InitiateDTO()
        dto.id = 1L
        dto.funds = FUNDS_STARTING_AMOUNT
        dto.popularity = POPULARITY_STARTING_AMOUNT
        dto.research = RESEARCH_STARTING_AMOUNT
        dto.supervisor = supervisor
        dto.tiles = generateStartingTiles();
        dto.buildingRequests = createBuildingRequests();
        return dto
    }

    fun generateStartingTiles(): List<Tile> {
        val startingTiles = createEmptyTiles()
        assignAreaTypes(startingTiles)
        assignBuildings(startingTiles)
        return startingTiles
    }

    fun assignAreaTypes(allTiles: List<Tile>) {
        val powerPlantTiles = setOf(0, 1, 2, 10, 11, 12, 20, 21, 22)
        setZoneType(POWER_PLANT_AREA, powerPlantTiles, allTiles)

        val housingTiles = setOf(5,6,7,8,9,15, 16, 17, 18, 19, 25, 26, 27, 28, 29, 44, 45, 46, 47, 54, 55, 56, 57, 64, 65, 74, 75)
        setZoneType(HOUSING_AREA, housingTiles, allTiles)

        val commercialTiles = setOf(40, 41, 42, 50, 51, 52, 60, 61, 62, 70, 71, 72)
        setZoneType(COMMERCIAL_AREA, commercialTiles, allTiles)

        val seaTiles = setOf(58, 59, 67, 68, 69, 76, 77, 78, 79)
        setZoneType(SEA_AREA, seaTiles, allTiles)

        val allTileIds = allTiles.map { it.id }.toSet()
        val remainingTiles = allTileIds - (powerPlantTiles + housingTiles + commercialTiles + seaTiles)
        setZoneType(GRASSlAND_AREA, remainingTiles, allTiles)
    }

    fun assignBuildings(tiles: List<Tile>) {
        setBuildingToTile(11, COAL_PLANT, tiles)
//        setBuildingToTile(13, HOOGSPANNINGS_MAST, tiles)
//        setBuildingToTile(23, HOOGSPANNINGS_MAST, tiles)
        setBuildingToTile(25, MIDDENSPANNINGS_STATION, tiles)
        setBuildingToTile(33, HOOGSPANNINGS_STATION, tiles)
        setBuildingToTile(35, TOWN_HALL, tiles)
        setBuildingToTile(42, MIDDENSPANNINGS_STATION, tiles)
        setBuildingToTile(44, MIDDENSPANNINGS_STATION, tiles)
        setBuildingToTile(56, VRIJSTAAND_HUIS, tiles)
        setBuildingToTile(75, VRIJSTAAND_HUIS, tiles)
    }
    fun createBuildingRequests(): List<BuildingRequestDTO> {
        return listOf(
            BuildingRequestDTO(COAL_PLANT, 5000, 0, 0, 0, 0, 0),
//            BuildingRequestDTO(HOOGSPANNINGS_MAST, 0, 0, 0, 0, 0),
//            BuildingRequestDTO(HOOGSPANNINGS_MAST, 0, 0, 0, 0, 0),
            BuildingRequestDTO(HOOGSPANNINGS_STATION, 0, 0, 0, 0, 0, 0),
            BuildingRequestDTO(MIDDENSPANNINGS_STATION, 0, 0, 0, 0, 0, 0),
            BuildingRequestDTO(MIDDENSPANNINGS_STATION, 0, 0, 0, 0, 0, 0),
            BuildingRequestDTO(MIDDENSPANNINGS_STATION, 0, 0, 0, 0, 0, 0),
            BuildingRequestDTO(TOWN_HALL, 150, 10, 10, 0, 15, 15),
            BuildingRequestDTO(VRIJSTAAND_HUIS, 20, 2, 2, 0, 2, 2),
            BuildingRequestDTO(VRIJSTAAND_HUIS, 20, 2, 2, 0, 2, 2)
        )
    }
}