package com.example.calaverabackend.controller;

import com.example.calaverabackend.controller.DTO.ConnectRequest;
import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.service.services.GameService;
import com.example.calaverabackend.service.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins="http://localhost:3000")
public class GameController {


    private PlayerService playerService;
    private GameService gameService;
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired GameController(PlayerService playerService, GameService gameService){
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public ResponseEntity<Game> start(@RequestBody Player player) {
        return ResponseEntity.ok(gameService.createGame(player));
    }

    @PostMapping("/connect")
    public Game connect(@RequestBody ConnectRequest request){
        System.out.println(request.getPlayer());
        System.out.println(request.getGameId());
        Game game = gameService.connectToGame(request.getPlayer(), request.getGameId());
        return game;
    }

    @PostMapping("/registernewplayer")
    public void registerNewPlayer(@RequestBody Player player) {
        System.out.println(player);
        playerService.save(player);
    }

    @MessageMapping("/gameplay")
    @SendTo("/topic/wstest")
    public Game getMessages(){
        Game game = Game.builder().gameId(2L).build();
        System.out.println(game);
        return game;
    }
}
