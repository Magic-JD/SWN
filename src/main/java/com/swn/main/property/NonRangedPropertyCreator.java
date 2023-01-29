package com.swn.main.property;


import com.swn.main.dice.Dice;
import jakarta.annotation.PostConstruct;

import java.util.List;

public abstract class NonRangedPropertyCreator extends PropertyCreator {

    private List<String> mapping;

    @PostConstruct
    @Override
    protected void initMapping() {
        mapping = resourceExtractor.nonRangedResourceMapping(getFile());
    }

    @Override
    protected int getRoll() {
        return Dice.roll1DN(mapping.size());
    }

    @Override
    protected String getString(int roll) {
        return mapping.get(roll - 1);
    }
}
