package com.swn.main.generator.npc.patron;


import com.swn.main.generator.npc.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class PatronNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/patron";
    }
}
