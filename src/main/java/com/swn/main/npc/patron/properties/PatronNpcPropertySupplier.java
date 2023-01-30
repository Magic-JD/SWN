package com.swn.main.npc.patron.properties;


import com.swn.main.npc.properties.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class PatronNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/patron";
    }
}
