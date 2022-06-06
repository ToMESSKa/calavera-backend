package com.example.calaverabackend.service.interfaces;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;

import java.util.List;

public interface IGameService {
    public Game createGame(Player player);

    public Game connectToGame(Player player2, Long gameId);

    public Game connectToRandomGame(Player player2);

    void save(Game game);
}
