package com.swn.main.generator.encounter.wilderness;

import com.swn.main.generator.encounter.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class WildernessEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/wilderness";
    }
}
