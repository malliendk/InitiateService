package com.dillian.initiateservice.services;

import com.dillian.initiateservice.dtos.GameDTO;
import com.dillian.initiateservice.dtos.InitiateGameDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class GameDtoService {

    private final InitiateGamePostService initiateGamePostService;
    private final GameDtoBuilderService gameDtoBuilderService;
    private GameDTO gameDTO;


    public GameDtoService(InitiateGamePostService initiateGamePostService, GameDtoBuilderService gameDtoBuilderService) {
        this.initiateGamePostService = initiateGamePostService;
        this.gameDtoBuilderService = gameDtoBuilderService;
    }

    public void createGame(InitiateGameDTO initiateGameDTO) {
        GameDTO gameDTO = gameDtoBuilderService.assembleInitiateDTO(initiateGameDTO);
        this.gameDTO = gameDTO;
        initiateGamePostService.initiateServicesAndSchedulers(gameDTO);
    }
}
