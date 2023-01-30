package com.swn.main.encounter.properties;

import com.swn.main.property.supplier.NonRangedPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class EncounterPropertySupplier extends NonRangedPropertySupplier {

    @Override
    protected String getFilePackage() {
        return "src/main/resources/random_gen/encounter";
    }
}
