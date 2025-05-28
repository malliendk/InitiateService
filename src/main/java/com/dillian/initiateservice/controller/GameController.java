package com.dillian.initiateservice.controller;

import com.dillian.initiateservice.dtos.InitiateDTO;
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

    private final GameCreationService builderService;
    private final InitiateGamePostService initiateGamePostService;

    @PostMapping()
    public ResponseEntity<InitiateDTO> startGame() {
        InitiateDTO initiateDTO = builderService.assembleInitiateDTO();
        initiateGamePostService.initiateCalculationService(initiateDTO);
        return ResponseEntity.ok(initiateDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<InitiateDTO> updateGameDTO(@RequestBody InitiateDTO gameTransferDto, @PathVariable Long id) throws Exception {
        if (!gameTransferDto.getId().equals(id)) {
            throw new Exception("ids don't match!");
        }
        log.info("dto received in initiateService: {}", gameTransferDto);

        //        purchaseValidationService.validateSolarPanelCapacity(gameDto);
        initiateGamePostService.updateGameCalculationService(gameTransferDto);
        return ResponseEntity.ok(gameTransferDto);
    }
}