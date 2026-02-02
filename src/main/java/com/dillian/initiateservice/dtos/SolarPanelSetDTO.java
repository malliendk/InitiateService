package com.dillian.initiateservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.dillian.initiateservice.util.StartingValuesKt.*;

@Getter
@Setter
@ToString
public class SolarPanelSetDTO {

    private int energyProduction = SOLAR_PANEL_BASIC_PRODUCTION;
    private int researchIncome = SOLAR_PANEL_BASIC_RESEARCH;
    private int goldIncome = SOLAR_PANEL_BASIC_GOLD_INCOME;
    private int environmentIncome = SOLAR_PANEL_BASIC_ENVIRONMENTAL_SCORE;
}
