package com.swn.main.npc.patron.properties;


import com.swn.main.npc.properties.NpcPropertyCreator;
import org.springframework.stereotype.Component;

@Component
public abstract class PatronNpcPropertyCreator extends NpcPropertyCreator {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/patron";
    }
}
