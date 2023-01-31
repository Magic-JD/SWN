package com.swn.main.npc.patron;


import com.swn.main.npc.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class PatronNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/patron";
    }
}
