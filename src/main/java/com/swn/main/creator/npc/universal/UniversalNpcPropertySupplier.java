package com.swn.main.creator.npc.universal;

import com.swn.main.creator.npc.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class UniversalNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/universal";
    }
}
