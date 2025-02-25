package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.GameTransferDTO;
import com.dillian.initiateservice.util.StartingValues;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameDtoBuilderService {

    private final EntityRetrieveService retrieveService;

    public GameTransferDTO assembleInitiateDTO() {
        GameTransferDTO initialGameTransferDto = new GameTransferDTO();
        initialGameTransferDto.setId(1L);
        setBasicStats(initialGameTransferDto);
        initialGameTransferDto.setBuildingIdSolarPanelMap(retrieveService.getBuildings());
        return initialGameTransferDto;
    }

    private void setBasicStats(GameTransferDTO gameTransferDTO) {
        gameTransferDTO.setFunds(StartingValues.FUNDS_STARTING_AMOUNT);
        gameTransferDTO.setPopularity(StartingValues.POPULARITY_STARTING_AMOUNT);
    }
}
