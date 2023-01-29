package com.swn.main.npc.properties;

import com.swn.main.property.NonRangedPropertyCreator;
import org.springframework.stereotype.Component;

@Component
public abstract class NpcPropertyCreator extends NonRangedPropertyCreator {

    @Override
    protected String getFilePackage(){
        return "src/main/resources/random_gen/npc";
    }
}
