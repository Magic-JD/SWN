package com.swn.main.generator.world;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class WorldPropertySupplier extends PropertySupplierImpl {

    @Override
    protected String getFilePackage() {
        return "src/main/resources/random_gen/world";
    }

    @Override
    protected int getDiceNumber() {
        return 2;
    }
}
