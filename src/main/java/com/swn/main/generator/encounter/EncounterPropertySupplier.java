package com.swn.main.generator.encounter;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class EncounterPropertySupplier extends PropertySupplierImpl {

    @Override
    protected String getFilePackage() {
        return "/random_gen/encounter";
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }
}
