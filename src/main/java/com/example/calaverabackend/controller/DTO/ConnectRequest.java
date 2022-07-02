package com.example.calaverabackend.controller.DTO;


import com.example.calaverabackend.model.Player;
import lombok.Data;

@Data
public class ConnectRequest {
    private Player player;
    private Long gameId;
}