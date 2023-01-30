package com.swn.main.world.properties;

import com.swn.main.property.supplier.RangedPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class WorldPropertySupplier extends RangedPropertySupplier {

    @Override
    protected String getFilePackage() {
        return "src/main/resources/random_gen/world";
    }
}
