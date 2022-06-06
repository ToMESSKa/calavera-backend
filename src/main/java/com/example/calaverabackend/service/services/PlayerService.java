package com.example.calaverabackend.service.services;

import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.repository.PlayerRepository;
import com.example.calaverabackend.service.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public List<Player> findPlayersByGameId(Long gameId) {
        return playerRepository.findPlayersByGameId(gameId);
    }


}
