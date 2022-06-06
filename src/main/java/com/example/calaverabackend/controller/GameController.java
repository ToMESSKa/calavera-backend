package com.example.calaverabackend.controller;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.service.services.GameService;
import com.example.calaverabackend.service.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class GameController {


    private PlayerService playerService;
    private GameService gameService;

    @Autowired GameController(PlayerService playerService, GameService gameService){
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public ResponseEntity<Game> start(@RequestBody Player player) {
        return ResponseEntity.ok(gameService.createGame(player));
    }

    @PostMapping("/registernewplayer")
    public void registerNewPlayer(@RequestBody Player player) {
        System.out.println(player);
        playerService.save(player);
    }
}
