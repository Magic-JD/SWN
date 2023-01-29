package com.swn.main.encounter.properties;

import com.swn.main.property.NonRangedPropertyCreator;
import org.springframework.stereotype.Component;

@Component
public abstract class EncounterPropertyCreator extends NonRangedPropertyCreator {

    @Override
    protected String getFilePackage(){
        return "src/main/resources/random_gen/encounter";
    }
}
