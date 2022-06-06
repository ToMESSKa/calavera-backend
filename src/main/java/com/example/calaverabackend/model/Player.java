package com.example.calaverabackend.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "player1", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<Game> gamesAsFirstPlayer;

    private String playerName;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
