package com.swn.main.encounter.wilderness.properties;

import com.swn.main.encounter.properties.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class WildernessEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/wilderness";
    }
}
