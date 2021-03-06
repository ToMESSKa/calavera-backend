package com.example.calaverabackend.repository;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    public Game findGameByGameId(Long gameId);

}
