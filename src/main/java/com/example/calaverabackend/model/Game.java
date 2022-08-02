package com.example.calaverabackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Game {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long gameId;

        private GameStatus gameStatus;

        @ManyToMany(mappedBy = "games", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
        @EqualsAndHashCode.Exclude
        private List<Player> players;

        public void setPlayers(List<Player> players) {
                if (players.size() >= 2) {
                        this.players = players;
                }
        }

        @Override
        public String toString() {
                return "Game{" +
                        "gameId=" + gameId +
                        ", players=" + players +
                        '}';
        }
}
