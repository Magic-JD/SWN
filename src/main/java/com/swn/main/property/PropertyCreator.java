package com.swn.main.property;

import com.swn.main.dice.Dice;
import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class PropertyCreator implements Property {

    @Autowired ResourceExtractor resourceExtractor;

    @PostConstruct
    protected abstract void initMapping();
    protected abstract int getRoll();
    protected abstract String getString(int roll);

    @Override
    public String getProperty(){
        int roll = getRoll();
        return getName() + ": " + getString(roll);
    }

    private String getName(){
        return getClass().getSimpleName();
    }
    protected String getFile(){
        return getFilePackage() + "/" + getName().toLowerCase() + ".txt";
    }

    protected abstract String getFilePackage();
}
