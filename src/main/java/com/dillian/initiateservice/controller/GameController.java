package com.dillian.initiateservice.controller;

import com.dillian.initiateservice.dtos.GameTransferDTO;
import com.dillian.initiateservice.exceptions.SolarPanelCapacityException;
import com.dillian.initiateservice.services.GameDtoBuilderService;
import com.dillian.initiateservice.services.InitiateGamePostService;
import com.dillian.initiateservice.services.PurchaseValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping()
@AllArgsConstructor
public class GameController {

    private final GameDtoBuilderService builderService;
    private final InitiateGamePostService initiateGamePostService;
    private final PurchaseValidationService purchaseValidationService;

    @PostMapping()
    public ResponseEntity<GameTransferDTO> startGame() {
        GameTransferDTO gameTransferDto = builderService.assembleInitiateDTO();
        initiateGamePostService.initiateCalculationService(gameTransferDto);
        return ResponseEntity.ok(gameTransferDto);
    }

    @PutMapping()
    public ResponseEntity<GameTransferDTO> updateGameDTO(@RequestBody GameTransferDTO gameTransferDto) throws SolarPanelCapacityException {
//        purchaseValidationService.validateSolarPanelCapacity(gameDto);
        initiateGamePostService.updateGameCalculationService(gameTransferDto);
        return ResponseEntity.ok(gameTransferDto);
    }
}
