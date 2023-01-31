package com.swn.main.property.display;

import com.swn.main.property.supplier.PropertySupplier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class DisplayProperties<T extends PropertySupplier> {

    @Autowired protected List<T> properties;

    public String displayProperties() {
        return properties
                .stream()
                .map(PropertySupplier::getPropertyString)
                .collect(Collectors.joining("\n"));
    }
}
