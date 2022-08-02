package com.example.calaverabackend.service.interfaces;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;

public interface IGameService {
    public Game createNewGame(Player player);

    public Game connectToNewGame(Player player2, Long gameId);

    public Game connectToRandomGame(Player player2);
}
