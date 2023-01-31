package com.swn.main.npc.universal.properties.name.properties;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class RegionalPropertySupplier extends PropertySupplierImpl {

    public String region = "arabic";

    @Override
    public String getPropertyDetails() {
        int roll = getRoll();
        return getString(roll);
    }

    @Override
    protected String getFilePackage() {
        return "src/main/resources/random_gen/npc/universal/name/" + region;
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }
}
