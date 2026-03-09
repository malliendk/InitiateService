package com.dillian.initiateservice.services

import com.dillian.initiateservice.dtos.*
import com.dillian.initiateservice.util.*
import org.springframework.stereotype.Service

@Service
class GameCreationService(
    private val tileCreationService: TileCreationService,
    private val buildingCreationService: BuildingCreationService
) {

    fun buildInitiateDTO(supervisor: SupervisorDTO): GameDTO {
        return GameDTO(
            1L,
            0,
            0,
            0,
            FUNDS_STARTING_AMOUNT,
            0,
            0,
            0,
            POPULARITY_STARTING_AMOUNT,
            0,
            RESEARCH_STARTING_AMOUNT,
            0,
            0,
            0,
            supervisor,
            assignBuildingsToTiles(),
            "",
            ""
        )
    }

    fun assignBuildingsToTiles(): List<Tile> {
        val tiles: List<Tile> = tileCreationService.generateStartingTiles()
        val buildingsWithTiles = buildingCreationService.createBuildingsInGame()
        val buildingsByTileId = buildingsWithTiles.associate { (building, tileId) -> tileId to building }
        tiles.forEach { tile ->
            tile.building = buildingsByTileId[tile.id]
        }
        return tiles
    }
}