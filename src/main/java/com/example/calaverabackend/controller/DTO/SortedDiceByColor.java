package com.example.calaverabackend.controller.DTO;


import lombok.Data;

import java.util.ArrayList;

@Data
public class SortedDiceByColor {
    private ArrayList<Dice> black;
    private ArrayList<Dice> turquoise;
    private ArrayList<Dice> rose;
    private ArrayList<Dice> orange;
    private ArrayList<Dice> purple;
    private ArrayList<Dice> skull;


}