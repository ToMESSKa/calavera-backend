package com.example.calaverabackend.controller.DTO;


import com.example.calaverabackend.model.Player;
import lombok.Data;

@Data
public class TurnIsOver {
    private boolean turnIsOver;
    private int startingPlayer;
}