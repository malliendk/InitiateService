package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.GameDTO;
import com.dillian.initiateservice.dtos.InitiateDTO;
import com.dillian.initiateservice.dtos.SolarPanelSetDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameDtoBuilderService {

    private final EntityRetrieveService retrieveService;
    private final SolarPanelService solarPanelService;

    public GameDTO assembleInitiateDTO(InitiateDTO initDto) {
        GameDTO initialGameDto = new GameDTO();
        initialGameDto.setSupervisor(retrieveService.getSupervisorDTO(initDto));
        initialGameDto.setBuildings(retrieveService.getBuildings());
        List<SolarPanelSetDTO> solarPanels = solarPanelService.createInitialSets(initialGameDto);
        solarPanelService.addSetsToTownHall(solarPanels, initialGameDto);
        return initialGameDto;
    }
}
