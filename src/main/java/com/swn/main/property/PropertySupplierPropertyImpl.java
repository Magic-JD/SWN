package com.swn.main.property;

import com.swn.main.property.supplier.PropertySupplierImpl;
import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;

import java.util.Collections;
import java.util.List;

public class PropertySupplierPropertyImpl extends PropertySupplierImpl implements Property {

    private final String description;
    private final int startNumber;
    private final int endNumber;
    private final String propertyLink;

    public PropertySupplierPropertyImpl(String description, int startNumber, int endNumber, String propertyLink, ResourceExtractor resourceExtractor) {
        this.description = description;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.propertyLink = propertyLink;
        this.resourceExtractor = resourceExtractor;
        initProperties();
    }

    @PostConstruct
    public void initProperties() {
        properties = resourceExtractor.resourceMapping(propertyLink);
    }

    @Override
    public int getMaxRoll() {
        return endNumber;
    }

    @Override
    public String getPropertyDetails() {
        return getString(getRoll());
    }

    @Override
    public boolean matchesRoll(int roll) {
        return roll >= startNumber && roll <= endNumber;
    }

    @Override
    public List<Integer> provideFurtherRolls() {
        return Collections.emptyList();
    }

    @Override
    protected String getFilePackage() {
        return null;
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }
}
