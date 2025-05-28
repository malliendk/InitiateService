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
    private int energyProduction;
    private int energyConsumption;
    private int excessBalance;
    private int gridCapacity;
    private double gridLoad;
    private List<Integer> incomingExcessBalances;
    private List<Tile> tiles;
}
