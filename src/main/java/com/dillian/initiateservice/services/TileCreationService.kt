package com.dillian.initiateservice.services

import com.dillian.initiateservice.dtos.Tile
import com.dillian.initiateservice.util.STARTING_TILE_AMOUNT

fun createEmptyTiles(): List<Tile> = (0 until  STARTING_TILE_AMOUNT).map { i ->
    Tile(
        id = i,
        buildingId = 0,
        zoneType = ""
    )
}

fun setZoneType(areaType: String, tileIds: Set<Int>, allTiles: List<Tile>) {
    allTiles.filter { it.id in tileIds }
        .forEach { it.zoneType = areaType }
}

fun setBuildingToTile(tileId: Int, buildingId: Long, allTiles: List<Tile>) {
    allTiles.filter { it.id == tileId }
        .forEach { it.buildingId = buildingId }
}
