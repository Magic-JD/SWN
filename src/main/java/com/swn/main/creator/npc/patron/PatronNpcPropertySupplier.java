package com.swn.main.creator.npc.patron;


import com.swn.main.creator.npc.NpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class PatronNpcPropertySupplier extends NpcPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/patron";
    }
}
