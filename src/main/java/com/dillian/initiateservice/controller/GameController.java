package com.dillian.initiateservice.controller;

import com.dillian.initiateservice.dtos.GameDTO;
import com.dillian.initiateservice.dtos.SupervisorDTO;
import com.dillian.initiateservice.services.GameCreationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@AllArgsConstructor
@Slf4j
public class GameController {

    private final GameCreationService gameCreationService;

    @PostMapping()
    public ResponseEntity<GameDTO> startGame(@RequestBody SupervisorDTO supervisor) {
        return ResponseEntity.ok(gameCreationService.buildInitiateDTO(supervisor));
    }
}