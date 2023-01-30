package com.swn.main.encounter.urban.properties;

import com.swn.main.encounter.properties.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class UrbanEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/urban";
    }
}
