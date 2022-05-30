package com.example.calaverabackend.configuration;

import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.repository.PlayerRepository;
import com.example.calaverabackend.service.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfiguration {

        @Autowired
        PlayerService playerService;

        @Bean
        CommandLineRunner commandLineRunnerAddUser(PlayerRepository playerRepository) {
            return args -> {
                Player player = Player.builder()
                        .playerName("tamas")
                        .build();
                playerService.save(player);
            };
        };
    }
