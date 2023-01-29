package com.swn.main.encounter.urban.properties;

import com.swn.main.encounter.properties.EncounterPropertyCreator;
import com.swn.main.npc.properties.NpcPropertyCreator;
import org.springframework.stereotype.Component;

@Component
public abstract class UrbanEncounterPropertyCreator extends EncounterPropertyCreator {

    @Override
    protected String getFilePackage(){
        return super.getFilePackage() +  "/urban";
    }
}
