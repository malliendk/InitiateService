package com.dillian.initiateservice.services

import com.dillian.initiateservice.dtos.BuildingDTO
import com.dillian.initiateservice.dtos.BuildingInGame
import com.dillian.initiateservice.util.*
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Service
class BuildingCreationService(
    private val restClient: RestClient
) {

    fun createBuildingsInGame(): List<Pair<BuildingInGame, Int>> {
        val buildingTilePairs = listOf(
            COAL_PLANT to 11,
            MIDDENSPANNINGS_STATION to 25,
            HOOGSPANNINGS_STATION to 33,
            TOWN_HALL to 35,
            MIDDENSPANNINGS_STATION to 42,
            MIDDENSPANNINGS_STATION to 44,
            VRIJSTAAND_HUIS to 56,
            VRIJSTAAND_HUIS to 75,
        )
        return buildingTilePairs.map { (buildingId, tileId) ->
            val building = mapToBuildingInGame(findBuildingById(buildingId))
            building to tileId
        }.also { pairs -> setBuildingId(pairs.map { it.first }) }
    }

    private fun findBuildingById(id: Int): BuildingDTO {
        return restClient.get()
            .uri("http://localhost:8090/$id")
            .accept(APPLICATION_JSON)
            .retrieve()
            .body<BuildingDTO>()
            ?: throw RuntimeException("Building with id $id not found")
    }

    private fun setBuildingId(buildings: List<BuildingInGame>) {
        var id = 1;
        for (building in buildings) {
            building.id = id
            id++
        }
    }

    private fun mapToBuildingInGame(dto: BuildingDTO): BuildingInGame {
        return BuildingInGame(
            0,
            dto.name,
            dto.description,
            dto.price,
            dto.imageUri,
            dto.gridCapacity,
            dto.energyProduction,
            dto.housing,
            dto.energyConsumption,
            dto.goldIncome,
            dto.popularityIncome,
            dto.researchIncome,
            dto.solarPanelAmount,
            dto.solarPanelCapacity,
            dto.canBePurchased
        )
    }
}