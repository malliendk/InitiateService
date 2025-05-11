package com.dillian.initiateservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tile {

    private Long id;
    private Long buildingId;
    private Long districtId;
}
