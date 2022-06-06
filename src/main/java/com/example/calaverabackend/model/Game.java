package com.example.calaverabackend.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Game {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long gameId;

        @ManyToOne
        private Player player1;

        @ManyToOne
        private Player player2;

        @Override
        public String toString() {
                return "Game{" +
                        "gameId=" + gameId +
                        ", player1=" + player1 +
                        ", player2=" + player2 +
                        '}';
        }
}
