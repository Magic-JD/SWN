package com.swn.main.creator.pc.origin;

import com.swn.main.property.PropertyInfo;
import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public abstract class OriginPropertySupplier extends PropertySupplierImpl {


    @Override
    protected String getFilePackage() {
        return "src/main/resources/creator/pc/origin";
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }

    public Optional<PropertyInfo> getPropertyBasedOnString(String s){
        return properties.stream()
                .filter(p -> p.getPropertyDetails().toLowerCase().startsWith(s.toLowerCase()))
                .findFirst().map(p -> new PropertyInfo(getName(), p.getPropertyDetails()));
    }
}
