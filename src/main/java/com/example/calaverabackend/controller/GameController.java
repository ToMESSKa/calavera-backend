package com.example.calaverabackend.controller;

import com.example.calaverabackend.controller.DTO.*;
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

    @MessageMapping("/rolleddice")
    @SendTo("/topic/getdicerollresult")
    public DiceRoll getDiceRollResult(@RequestBody DiceRoll diceRoll){
        return diceRoll;
    }

    @MessageMapping("/selectedrerolldice")
    @SendTo("/topic/getseledteddicererollresult")
    public Dice getRerollResult(@RequestBody Dice dice){
        return dice;
    }

    @MessageMapping("/canceleddice")
    @SendTo("/topic/getcanceleddice")
    public Dice getCanceledDice(@RequestBody Dice dice){
        return dice;
    }

    @MessageMapping("/newdiceforroll")
    @SendTo("/topic/getnewdiceforroll")
    public DiceRoll getNewDiceForReroll(@RequestBody DiceRoll diceRoll){
        return diceRoll;
    }

    @MessageMapping("/selectedcolor")
    @SendTo("/topic/getselectedcolor")
    public Dice getSelectedColor(@RequestBody Dice dice){
        return dice;
    }

    @MessageMapping("/markedcells")
    @SendTo("/topic/getmarkedcells")
    public MarkedCells getMarkedCells(@RequestBody MarkedCells markedCells){
        System.out.println(markedCells);
        return markedCells;
    }

    @MessageMapping("/whoseturnitis")
    @SendTo("/topic/getwhoseturnitis")
    public WhoseTurnItIs getTurnOver(@RequestBody WhoseTurnItIs whoseTurnItIs){
        System.out.println(whoseTurnItIs);
        return whoseTurnItIs;
    }

}
