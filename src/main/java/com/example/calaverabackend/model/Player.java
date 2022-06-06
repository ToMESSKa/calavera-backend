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

    @ManyToMany
    private List<Game> games;

    private String playerName;
}
