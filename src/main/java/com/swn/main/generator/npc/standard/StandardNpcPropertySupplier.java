package com.swn.main.generator.npc.standard;

import com.swn.main.generator.npc.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class StandardNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/standard";
    }
}
