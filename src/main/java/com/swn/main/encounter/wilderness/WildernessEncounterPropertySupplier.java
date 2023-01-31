package com.swn.main.encounter.wilderness;

import com.swn.main.encounter.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class WildernessEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/wilderness";
    }
}
