package com.swn.main.npc.standard.properties;

import com.swn.main.npc.properties.NpcPropertyCreator;
import org.springframework.stereotype.Component;

@Component
public abstract class StandardNpcPropertyCreator extends NpcPropertyCreator {

    @Override
    protected String getFilePackage(){
        return super.getFilePackage() +  "/standard";
    }
}
