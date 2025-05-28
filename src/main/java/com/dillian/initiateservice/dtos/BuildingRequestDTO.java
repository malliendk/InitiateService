package com.dillian.initiateservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BuildingRequestDTO {

    private Long buildingId;
    private int solarPanelAmount;
    private int energyProduction;
    private int goldIncome;
    private int popularityIncome;
    private int researchIncome;
    private int environmentalScore;
}
