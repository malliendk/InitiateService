package com.dillian.initiateservice.services

import com.dillian.initiateservice.dtos.Tile
import com.dillian.initiateservice.util.*
import org.springframework.stereotype.Service

@Service
class TileCreationService {

    fun generateStartingTiles(): List<Tile> {
        val startingTiles = createEmptyTiles()
        assignZoneTypes(startingTiles)
        return startingTiles
    }

    private fun assignZoneTypes(allTiles: List<Tile>) {
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

    private fun createEmptyTiles(): List<Tile> = (0 until STARTING_TILE_AMOUNT).map { i ->
        Tile(
            id = i,
            zoneType = ""
        )
    }

    private fun setZoneType(areaType: String, tileIds: Set<Int>, allTiles: List<Tile>) {
        allTiles.filter { it.id in tileIds }
            .forEach { it.zoneType = areaType }
    }
}