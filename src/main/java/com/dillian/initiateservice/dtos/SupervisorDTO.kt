package com.dillian.initiateservice.dtos

class SupervisorDTO(
    val id: Long = 0,
    val name: String = "",
    val imageUrl: String = "",
    val biography: String = "",
    val classType: String = "",
    val type: String = "",
    val specialAbility: String = "",
    var perkGoldIncome: Int = 0,
    var perkGoldCost: Int = 0,
    var perkPopularityIncome: Int = 0,
    var perkPopularityCost: Int = 0,
    var perkResearchIncome: Int = 0,
    var perkResearchCost: Int = 0,
    var perkEnvironmentalIncome: Int = 0,
    var perkGridEfficiency: Int = 0,
    var perkLineResilience: Int = 0,
    var specialPerk: Int = 0
)