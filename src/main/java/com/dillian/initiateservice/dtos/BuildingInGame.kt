package com.dillian.initiateservice.dtos

class BuildingInGame(
    var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var price: Int = 0,
    var imageUri: String = "",
    var gridCapacity: Int = 0,
    var energyProduction: Int = 0,
    var housing: Int = 0,
    var energyConsumption: Int = 0,
    var goldIncome: Int = 0,
    var popularityIncome: Int = 0,
    var researchIncome: Int = 0,
    var solarPanelAmount: Int = 0,
    var solarPanelCapacity: Int = 0,
    var canBePurchased: Boolean = false
)