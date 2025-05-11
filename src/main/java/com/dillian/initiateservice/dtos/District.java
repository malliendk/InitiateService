package com.dillian.initiateservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class District {

    private Long id;
    private double energyProduction;
    private double energyConsumption;
    private int gridCapacity;
    private double gridLoad;
    private List<Tile> tiles;
}
