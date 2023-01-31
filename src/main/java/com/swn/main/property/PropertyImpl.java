package com.swn.main.property;

import java.util.Collections;
import java.util.List;

public class PropertyImpl implements Property {

    private final String description;
    private final int startNumber;
    private final int endNumber;

    public PropertyImpl(String description, int startNumber, int endNumber) {
        this.description = description;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public int getMaxRoll() {
        return endNumber;
    }

    @Override
    public String getPropertyDetails() {
        return description;
    }

    @Override
    public boolean matchesRoll(int roll) {
        return roll >= startNumber && roll <= endNumber;
    }

    @Override
    public List<Integer> provideFurtherRolls() {
        return Collections.emptyList();
    }
}
