package com.swn.main.npc.universal;

import com.swn.main.npc.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class UniversalNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/universal";
    }
}
