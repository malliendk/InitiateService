package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.BuildingDTO;
import com.dillian.initiateservice.dtos.GameDTO;
import com.dillian.initiateservice.dtos.SolarPanelSetDTO;
import com.dillian.initiateservice.util.Constants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolarPanelService {

    public List<SolarPanelSetDTO> createInitialSets(GameDTO initiateDTO) {
        List<SolarPanelSetDTO> solarPanels = new ArrayList<>();
        for (int i = 0; i < Constants.SOLAR_PANEL_STARTING_AMOUNT; i++) {
            SolarPanelSetDTO solarPanelSet = new SolarPanelSetDTO();
            solarPanelSet.setEnergyProduction(Constants.SOLAR_PANEL_BASIC_PRODUCTION);
            solarPanelSet.setResearchIncome(Constants.SOLAR_PANEL_BASIC_RESEARCH);
            solarPanelSet.setGoldIncome(Constants.SOLAR_PANEL_BASIC_INCOME);
            solarPanels.add(solarPanelSet);
        }
        if (solarPanels.size() != Constants.SOLAR_PANEL_STARTING_AMOUNT) {
            throw new RuntimeException("There are " + solarPanels.size() + "panels");
        }
        return solarPanels;
    }

    public void addSetsToTownHall(List<SolarPanelSetDTO> solarPanels, GameDTO initiateDTO) {
        BuildingDTO townHall = initiateDTO.getBuildings().getFirst();
        townHall.setSolarPanelSets(solarPanels);
    }
}
