package com.swn.main.property;

import com.swn.main.dice.Dice;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepeatingProperty extends PropertyImpl{

    private int repeating;
    private int rollMax;
    private Random random = new Random();

    public RepeatingProperty(int repeating, int rollMax, String description, int startNumber, int endNumber) {
        super(description, startNumber, endNumber);
        this.repeating = repeating;
        this.rollMax = rollMax;
    }

    @Override public List<Integer> provideFurtherRolls(){
        return Dice.rollXDNNonRepeating(repeating, rollMax);
    }
}
