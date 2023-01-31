package com.swn.main.creator.encounter.wilderness;

import com.swn.main.creator.encounter.EncounterPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public abstract class WildernessEncounterPropertySupplier extends EncounterPropertySupplier {

    @Override
    protected String getFilePackage() {
        return super.getFilePackage() + "/wilderness";
    }
}
