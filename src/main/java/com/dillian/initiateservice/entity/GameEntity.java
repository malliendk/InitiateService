package com.dillian.initiateservice.entity;

import com.dillian.initiateservice.dtos.District;
import com.dillian.initiateservice.dtos.Tile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GameEntity {

    private Long id;
    private String supervisorName;
    private List<Integer> buildingRequests;
    private List<Tile> tiles;
    private int funds;
    private int popularity;
    private int research;
    private int environmentalScore;
}
