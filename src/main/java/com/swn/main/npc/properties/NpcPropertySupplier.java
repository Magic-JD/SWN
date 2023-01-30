package com.swn.main.npc.properties;

import com.swn.main.property.supplier.NonRangedPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class NpcPropertySupplier extends NonRangedPropertySupplier {

    @Override
    protected String getFilePackage() {
        return "src/main/resources/random_gen/npc";
    }
}
