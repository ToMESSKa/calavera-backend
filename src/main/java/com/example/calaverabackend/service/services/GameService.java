package com.example.calaverabackend.service.services;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import com.example.calaverabackend.repository.GameRepository;
import com.example.calaverabackend.repository.PlayerRepository;
import com.example.calaverabackend.service.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService implements IGameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Game createGame(Player player) {
        List<Player> players = new ArrayList<>();
        players.add(player);
        Game game = Game.builder()
                .players(players)
                .build();
        playerRepository.save(player);
        gameRepository.save(game);
        return game;
    }
    @Override
    public Game connectToGame(Player player2, Long gameId) {
            Game game = gameRepository.findGameByGameId(gameId);
            if (doesTheGameNeedASecondPlayer(game)){
                List <Player> players = game.getPlayers();
                players.add(player2);
                game.setPlayers(players);
                save(game);
            }
            return game;
    }

    @Override
    public Game connectToRandomGame(Player player2) {
        return null;
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }


    public boolean doesTheGameNeedASecondPlayer(Game game) {
        return game.getPlayers().size() == 1;
    }


}
