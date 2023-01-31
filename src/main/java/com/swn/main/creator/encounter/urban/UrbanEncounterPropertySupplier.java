package com.swn.main.creator.encounter.urban;

import com.swn.main.creator.encounter.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class UrbanEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/urban";
    }
}
