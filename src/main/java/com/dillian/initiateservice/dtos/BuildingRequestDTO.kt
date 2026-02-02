package com.dillian.initiateservice.dtos

data class BuildingRequestDTO (

     var buildingId: Long = 0,
     var energyProduction: Int = 0,
     var goldIncome: Int = 0,
     var popularityIncome: Int = 0,
     var researchIncome: Int = 0,
     var environmentalScore: Int = 0,
     var solarPanelAmount: Int = 0,
     )