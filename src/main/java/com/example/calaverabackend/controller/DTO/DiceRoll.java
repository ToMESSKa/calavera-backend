package com.example.calaverabackend.controller.DTO;


import com.example.calaverabackend.model.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class DiceRoll {
    private ArrayList<Dice> diceRolls;

}