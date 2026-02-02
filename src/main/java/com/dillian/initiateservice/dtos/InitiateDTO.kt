package com.dillian.initiateservice.dtos

data class InitiateDTO(

    var id: Long = 0,
    var supervisor: SupervisorDTO? = null,
    var buildingRequests: List<BuildingRequestDTO> = mutableListOf(),
    var tiles: List<Tile> = mutableListOf(),
    var funds: Int = 0,
    var popularity: Int = 0,
    var research: Int = 0,
    var environmentalScore: Int = 0
)