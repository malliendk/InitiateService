package com.dillian.initiateservice.dtos

data class GameDTO(
    var id: Long = 0L,
    var energyConsumption: Int = 0,
    var energyProduction: Int = 0,
    var environmentalScore: Int = 0,
    var funds: Int = 0,
    var goldIncome: Int = 0,
    var gridCapacity: Int = 0,
    var housing: Int = 0,
    var popularity: Int = 0,
    var popularityIncome: Int = 0,
    var research: Int = 0,
    var researchIncome: Int = 0,
    var solarPanelAmount: Int = 0,
    var solarPanelCapacity: Int = 0,
    var supervisor: SupervisorDTO? = null,
    var tiles: List<Tile> = mutableListOf(),
    var timeOfDay: String = "",
    var weatherType: String = ""
)