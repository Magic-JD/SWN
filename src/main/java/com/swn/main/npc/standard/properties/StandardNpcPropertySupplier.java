package com.swn.main.npc.standard.properties;

import com.swn.main.npc.properties.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class StandardNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/standard";
    }
}
