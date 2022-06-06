package com.example.calaverabackend.repository;

import com.example.calaverabackend.model.Game;
import com.example.calaverabackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    public List <Player> findPlayersByGameId(Long gameId);
}
