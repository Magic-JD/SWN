package com.swn.main.world.properties;

import com.swn.main.dice.Dice;
import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public abstract class PropertyCreator {

    @Autowired ResourceExtractor resourceExtractor;
    private Map<Integer, String> mapping;


    @PostConstruct
    private void initMapping(){
        mapping = resourceExtractor.resourceMapping("src/main/resources/random_gen/" + getFile());
    }

    public String getProperty(){
        int roll = Dice.roll2D6();
        return getName() + ": " + mapping.get(roll);
    }

    abstract String getName();
    private String getFile(){
        return getName().toLowerCase() + ".txt";
    }
}
