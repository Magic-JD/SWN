package com.swn.main.generator.encounter.urban;

import com.swn.main.generator.encounter.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class UrbanEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/urban";
    }
}
