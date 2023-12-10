package com.swn.main.generator.npc;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class NpcPropertySupplier extends PropertySupplierImpl {

    @Override
    protected String getFilePackage() {
        return "./src/main/resources/random_gen/npc";
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }
}
