package com.example.calaverabackend.configuration;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.repository.PlayerRepository;
import com.example.calaverabackend.service.services.GameService;
import com.example.calaverabackend.service.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PlayerConfiguration {

        @Autowired
        PlayerService playerService;

        @Autowired
        GameService gameService;

        @Bean
        CommandLineRunner commandLineRunnerAddUser(PlayerRepository playerRepository) {
            return args -> {
                Game game = Game.builder()
                        .build();
                List<Game> gamesAsFirstPlayer = new ArrayList<>();
                gamesAsFirstPlayer.add(game);
                Player player = Player.builder()
                        .playerName("Tamas")
                        .gamesAsFirstPlayer(gamesAsFirstPlayer)
                        .build();
                game.setPlayer1(player);
                playerService.save(player);
                gameService.save(game);
                List<Game> games = gameService.findGamesByPlayer1(player);
                System.out.println(games.get(0));
            };
        };
    }
