package com.example.calaverabackend.controller.DTO;


import lombok.Data;

import java.util.ArrayList;

@Data
public class MarkedCells {
    private int numberOfDice;
    private int value;
    private int playerToMarkCells;


}