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
                List<Game> games = new ArrayList<>();
                games.add(game);
                Player player1 = Player.builder()
                        .playerName("Tamás")
                        .games(games)
                        .build();
                Player player2 = Player.builder()
                        .playerName("Dávid")
                        .games(games)
                        .build();
                List<Player> players = new ArrayList<>();
                game.setPlayers(players);
                gameService.save(game);
                playerService.save(player1);
                playerService.save(player2);

            };
        };
    }
