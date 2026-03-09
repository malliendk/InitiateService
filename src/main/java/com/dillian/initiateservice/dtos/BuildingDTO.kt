package com.dillian.initiateservice.dtos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BuildingDTO {

    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageUri;
    private int gridCapacity;
    private int energyProduction;
    private int housing;
    private int energyConsumption;
    private int goldIncome;
    private int popularityIncome;
    private int researchIncome;
    private boolean canBePurchased;
}
