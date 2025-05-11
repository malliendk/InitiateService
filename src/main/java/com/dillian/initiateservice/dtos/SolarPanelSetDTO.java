package com.dillian.initiateservice.dtos;

import com.dillian.initiateservice.util.BuildingIds;
import com.dillian.initiateservice.util.StartingValues;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SolarPanelSetDTO {

    private int energyProduction = StartingValues.SOLAR_PANEL_BASIC_PRODUCTION;
    private int researchIncome = StartingValues.SOLAR_PANEL_BASIC_RESEARCH;
    private int goldIncome = StartingValues.SOLAR_PANEL_BASIC_GOLD_INCOME;
    private int environmentIncome = StartingValues.SOLAR_PANEL_BASIC_ENVIRONMENTAL_SCORE;
}
