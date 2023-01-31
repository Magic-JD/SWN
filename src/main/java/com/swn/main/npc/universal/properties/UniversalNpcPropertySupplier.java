package com.swn.main.npc.universal.properties;

import com.swn.main.npc.properties.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class UniversalNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/universal";
    }
}
