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
        Game game = Game.builder()
                .build();
        List<Game> games = new ArrayList<>();
        games.add(game);
        player.setGames(games);
        List<Player> players = new ArrayList<>();
        game.setPlayers(players);
        gameRepository.save(game);
        playerRepository.save(player);
        return game;
    }
    @Override
    public Game connectToGame(Player player2, Long gameId) {
        Game game = gameRepository.findGameByGameId(gameId);
        if (doesTheGameNeedASecondPlayer(game)) {
            List<Player> players = game.getPlayers();
            player2.setPlayerName("Dávid");
            players.add(player2);
            game.setPlayers(players);
            List<Game> games = new ArrayList<>();
            games.add(game);
            player2.setGames(games);
            gameRepository.save(game);
            playerRepository.save(player2);
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
