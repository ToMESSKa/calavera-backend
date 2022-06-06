package com.example.calaverabackend.service.services;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.repository.GameRepository;
import com.example.calaverabackend.service.interfaces.IGameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService implements IGameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game createGame(Player player) {
        Game game = new Game();
        game.setPlayer1(player);
        gameRepository.save(game);
        return game;
    }

    @Override
    public Game connectToGame(Player player2, Long gameId) {
        return null;
    }

    @Override
    public Game connectToRandomGame(Player player2) {
        return null;
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }

    public List<Game> findGamesByPlayer1(Player player){
        return gameRepository.findGamesByPlayer1(player);
    }


}
