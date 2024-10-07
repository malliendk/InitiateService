package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameDtoBuilderService {

    private final EntityRetrieveService retrieveService;

    public GameDTO assembleInitiateDTO(InitiateGameDTO initDto) {
        GameDTO initiateGameDto = new GameDTO();
        initiateGameDto.setSupervisor(retrieveService.getSupervisorDTO(initDto));
        initiateGameDto.setBuildings(retrieveService.getBuildings());
        initiateGameDto.setSolarPanelSets(retrieveService.getSolarPanels());
        return initiateGameDto;
    }

}
