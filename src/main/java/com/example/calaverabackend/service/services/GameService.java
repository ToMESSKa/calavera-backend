package com.example.calaverabackend.service.services;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.GameStatus;
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
    public Game createNewGame(Player player) {
        if (player.getPlayerID() == null){
            playerRepository.save(player);
        }
        Game game = Game.builder()
                .build();
        game.setGameStatus(GameStatus.IN_PROGRESS);
        List<Game> games = new ArrayList<>();
        games.add(game);
        setEveryGameToNotInProgress(player);
        player.setGames(games);
        List<Player> players = new ArrayList<>();
        game.setPlayers(players);
        gameRepository.save(game);
        playerRepository.save(player);
        return game;
    }
    @Override
    public Game connectToNewGame(Player player2, Long gameId) {
        Game game = gameRepository.findGameByGameId(gameId);
        if (game== null){
            game = Game.builder()
                    .build();
            game.setGameStatus(GameStatus.NOT_FOUND);
            return game;
        }else if (doesTheGameNeedASecondPlayer(game)) {
            List<Player> players = game.getPlayers();
            players.add(player2);
            game.setPlayers(players);
            List<Game> games = new ArrayList<>();
            games.add(game);
            player2.setGames(games);
            playerRepository.save(player2);
            gameRepository.save(game);
        }
        return game;

    }
    @Override
    public Game connectToRandomGame(Player player2) {
        return null;
    }



    public boolean doesTheGameNeedASecondPlayer(Game game) {
        return game.getPlayers().size() == 1;
    }

    public void setEveryGameToNotInProgress(Player player) {
        List<Game> games =  playerRepository.getPlayerByPlayerID(player.getPlayerID()).getGames();
        if (games != null){
            for (Game game: games){
                if (game.getGameStatus()== GameStatus.IN_PROGRESS){
                    game.setGameStatus(GameStatus.NOT_IN_PROGRESS);
                }
            }
        }


    }

}
