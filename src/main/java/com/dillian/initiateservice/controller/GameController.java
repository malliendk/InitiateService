package com.dillian.initiateservice.controller;

import com.dillian.initiateservice.services.GameDtoService;
import com.dillian.initiateservice.dtos.InitiateGameDTO;
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

    private final GameDtoService gameDtoService;

    @PostMapping
    public ResponseEntity<Void> startGame(@RequestBody InitiateGameDTO initDto) {
        gameDtoService.createGame(initDto);
        return ResponseEntity.ok().build();
    }
}
