package com.swn.main.property;

import com.swn.main.dice.Dice;

import java.util.List;
import java.util.Random;

public class RepeatingProperty extends PropertyImpl {

    private final int repeating;
    private final int rollMax;
    private final Random random = new Random();

    public RepeatingProperty(int repeating, int rollMax, String description, int startNumber, int endNumber) {
        super(description, startNumber, endNumber);
        this.repeating = repeating;
        this.rollMax = rollMax;
    }

    @Override
    public List<Integer> provideFurtherRolls() {
        return Dice.rollXDNNonRepeating(repeating, rollMax);
    }
}
