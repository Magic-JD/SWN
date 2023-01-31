package com.swn.main.npc.standard;

import com.swn.main.npc.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class StandardNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/standard";
    }
}
