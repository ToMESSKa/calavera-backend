package com.example.calaverabackend.controller;

import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.service.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

public class RegisterNewPlayer {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/registernewplayer")
    public void registerNewPlayer(@RequestBody Player player) {
        playerService.save(player);
    }
}
