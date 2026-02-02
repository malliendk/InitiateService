package com.dillian.initiateservice.controller;

import com.dillian.initiateservice.dtos.InitiateDTO;
import com.dillian.initiateservice.dtos.SupervisorDTO;
import com.dillian.initiateservice.services.GameCreationService;
import com.dillian.initiateservice.services.InitiateGamePostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@AllArgsConstructor
@Slf4j
public class GameController {

    private final GameCreationService gameCreationService;
    private final InitiateGamePostService initiateGamePostService;

    @PostMapping()
    public ResponseEntity<InitiateDTO> startGame(@RequestBody SupervisorDTO supervisor) {
        InitiateDTO initiateDTO = gameCreationService.assembleInitiateDTO(supervisor);
        initiateGamePostService.initiateCalculationService(initiateDTO);
        log.info("iniateDTO created with tiles: {}", initiateDTO.getTiles());
        return ResponseEntity.ok(initiateDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<InitiateDTO> updateGameDTO(@RequestBody InitiateDTO gameTransferDTO, @PathVariable Long id) throws Exception {
        if (gameTransferDTO.getId() != id) {
            throw new Exception("ids don't match!");
        }
        log.info("dto received in initiateService: {}", gameTransferDTO);
        initiateGamePostService.updateGameCalculationService(gameTransferDTO);
        return ResponseEntity.ok(gameTransferDTO);
    }
}