package com.example.calaverabackend.service.interfaces;

import com.example.calaverabackend.model.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPlayerService {

    void save(Player player);
    public List<Player> findPlayersByGameId(Long gameId);
}
