package com.swn.main.property.supplier;

import com.swn.main.property.Property;
import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class PropertySupplierImpl implements PropertySupplier {

    @Autowired ResourceExtractor resourceExtractor;
    protected List<Property> properties;

    @PostConstruct
    protected void initProperties() {
        properties = supplyProperties();
    }

    protected abstract List<Property> supplyProperties();

    protected abstract int getRoll();

    protected String getString(int roll) {
        return properties
                .stream()
                .filter(property -> property.matchesRoll(roll))
                .findAny()
                .map(Property::getDescription)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public String getPropertyDetails() {
        int roll = getRoll();
        return getName() + ": " + getString(roll);
    }

    private String getName() {
        return getClass().getSimpleName();
    }

    protected String getFile() {
        return getFilePackage() + "/" + getName().toLowerCase() + ".txt";
    }

    protected abstract String getFilePackage();
}
