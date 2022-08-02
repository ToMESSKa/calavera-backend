package com.example.calaverabackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({ "games"})
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerID;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    private List<Game> games;

    private String playerName;


    @Override
    public String toString() {
        return "Player{" +
                "id=" + playerID +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
