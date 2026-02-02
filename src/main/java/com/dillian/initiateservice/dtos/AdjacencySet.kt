package com.dillian.initiateservice.dtos

class AdjacencySet(

    var buildingName1: String = "",
    var buildingName2: String = "",
    var affectedProperty: String = "",
    var effect: Int = 0,
    var hasAreaEffect: Boolean = false,
    var canBeConsumed: Boolean = false
)