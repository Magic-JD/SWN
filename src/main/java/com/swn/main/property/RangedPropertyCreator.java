package com.swn.main.property;


import com.swn.main.dice.Dice;
import jakarta.annotation.PostConstruct;

import java.util.Map;

public abstract class RangedPropertyCreator extends PropertyCreator {

    Map<Integer, String> mapping;

    @PostConstruct
    @Override
    protected void initMapping() {
        mapping = resourceExtractor.rangedResourceMapping(getFile());
    }

    @Override
    protected int getRoll() {
        return Dice.roll2D6();
    }

    @Override
    protected String getString(int roll) {
        return mapping.get(roll);
    }
}
