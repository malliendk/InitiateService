package com.dillian.initiateservice.controller;

import com.dillian.initiateservice.dtos.GameDTO;
import com.dillian.initiateservice.dtos.InitiateDTO;
import com.dillian.initiateservice.services.GameDtoBuilderService;
import com.dillian.initiateservice.services.InitiateGamePostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
@AllArgsConstructor
public class GameController {

    private final GameDtoBuilderService builderService;
    private final InitiateGamePostService initiateGamePostService;

    @PostMapping("start")
    public ResponseEntity<GameDTO> startGame(@RequestBody InitiateDTO initDto) {
        GameDTO gameDto = builderService.assembleInitiateDTO(initDto);
        return ResponseEntity.ok(gameDto);
    }
}
