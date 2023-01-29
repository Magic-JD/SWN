package com.swn.main.dice;

import java.util.Random;

public class Dice {
    private static final Random rand = new Random();

    public static int roll2D6(){
        return roll1D6() + roll1D6();
    }

    public static int roll1D6(){
        return rand.nextInt(1, 7);
    }

    public static int roll1DN(int n){
        return rand.nextInt(1, n+1);
    }
}
