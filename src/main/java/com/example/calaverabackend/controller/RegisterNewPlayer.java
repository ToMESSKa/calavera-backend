package com.example.calaverabackend.controller;

import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.service.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RegisterNewPlayer {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/registernewplayer")
    public void registerNewPlayer(@RequestBody Player player) {
        System.out.println("success");
        playerService.save(player);
    }
}
