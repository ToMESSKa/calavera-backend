package com.example.calaverabackend.service.services;

import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.repository.PlayerRepository;
import com.example.calaverabackend.service.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }
}
