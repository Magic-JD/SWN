package com.swn.main.encounter.wilderness.properties;

import com.swn.main.encounter.properties.EncounterPropertyCreator;
import org.springframework.stereotype.Component;

@Component
public abstract class WildernessEncounterPropertyCreator extends EncounterPropertyCreator {

    @Override
    protected String getFilePackage(){
        return super.getFilePackage() +  "/wilderness";
    }
}
