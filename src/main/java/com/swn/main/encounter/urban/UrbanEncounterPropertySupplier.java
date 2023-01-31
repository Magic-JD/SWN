package com.swn.main.encounter.urban;

import com.swn.main.encounter.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class UrbanEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/urban";
    }
}
