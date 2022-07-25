package com.example.calaverabackend.controller.DTO;


import com.example.calaverabackend.model.Player;
import lombok.Data;

import java.util.HashMap;

@Data
public class DiceRoll {
    private HashMap <String, String> diceRolls;
}