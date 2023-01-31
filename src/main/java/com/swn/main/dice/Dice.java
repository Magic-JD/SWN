package com.swn.main.dice;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Dice {
    private static final Random rand = new Random();

    public static int roll2D6() {
        return roll1D6() + roll1D6();
    }

    public static int roll1D6() {
        return rand.nextInt(1, 7);
    }

    public static int roll1DN(int n) {
        return rand.nextInt(1, n + 1);
    }

    public static int rollXDN(int x, int n) {
        int total = 0;
        for (int i = 0; i < x; i++) {
            total += roll1DN(n);
        }
        return total;
    }

    public static List<Integer> rollXDNNonRepeating(int x, int n) {
        return rand
                .ints(1, n + 1)
                .distinct()
                .limit(x)
                .boxed()
                .collect(Collectors.toList());
    }
}
