package com.example.calaverabackend.controller;

import com.example.calaverabackend.controller.DTO.ConnectRequest;
import com.example.calaverabackend.controller.DTO.DiceRoll;
import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.service.services.GameService;
import com.example.calaverabackend.service.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:3000")
public class GameController {


    private PlayerService playerService;
    private GameService gameService;

    @Autowired GameController(PlayerService playerService, GameService gameService){
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @PostMapping("/startnewgame")
    public ResponseEntity<Game> start(@RequestBody Player player) {
        return ResponseEntity.ok(gameService.createNewGame(player));
    }

    @PostMapping("/joinnewgame")
    public Game connect(@RequestBody ConnectRequest request){
        Game game = gameService.connectToNewGame(request.getPlayer(), request.getGameId());
        return game;
    }

    @MessageMapping("/rolldice")
    @SendTo("/topic/dicerollresult")
    public DiceRoll getDiceRollResult(@RequestBody DiceRoll diceRoll){
        System.out.println(diceRoll);
        return diceRoll;
    }
}
