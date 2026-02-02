package com.dillian.initiateservice.dtos

data class Tile(
    var id: Int = 0,
    var buildingId: Long = 0,
    var building: BuildingDTO? = null,
    var zoneType: String = "",
    var adjacencySet: AdjacencySet? = null,
    var hasPowerLine: Boolean = false,
)