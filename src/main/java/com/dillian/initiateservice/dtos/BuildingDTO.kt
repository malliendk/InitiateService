package com.dillian.initiateservice.dtos

/**
 * Data Transfer Object for Building information
 */
class BuildingDTO(
    var id: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: Int = 0,
    val imageUri: String = "",
    val gridCapacity: Int = 0,
    val energyProduction: Int = 0,
    val housing: Int = 0,
    val energyConsumption: Int = 0,
    val goldIncome: Int = 0,
    val popularityIncome: Int = 0,
    val researchIncome: Int = 0,
    val solarPanelAmount: Int = 0,
    val solarPanelCapacity: Int = 0,
    val canBePurchased: Boolean = false
)