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

        @ManyToMany(mappedBy = "games", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
        @EqualsAndHashCode.Exclude
        private List<Player> players;

}
