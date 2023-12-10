package com.swn.main.generator.npc;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class NpcPropertySupplier extends PropertySupplierImpl {

    @Override
    protected String getFilePackage() {
        return "/random_gen/npc";
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }
}
