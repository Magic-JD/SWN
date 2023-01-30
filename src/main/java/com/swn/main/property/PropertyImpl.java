package com.swn.main.property;

public class PropertyImpl implements Property {

    private String description;
    private int startNumber;
    private int endNumber;

    public PropertyImpl(String description, int number){
        this.description = description;
        this.startNumber = number;
        this.endNumber = number;
    }

    public PropertyImpl(String description, int startNumber, int endNumber) {
        this.description = description;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public boolean matchesRoll(int roll){
        return roll >= startNumber && roll <= endNumber;
    }
}
