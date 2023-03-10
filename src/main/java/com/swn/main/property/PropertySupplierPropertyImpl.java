package com.swn.main.property;

import com.swn.main.property.supplier.PropertySupplierImpl;
import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

public class PropertySupplierPropertyImpl extends PropertySupplierImpl implements Property {

    private final int startNumber;
    private final int endNumber;
    private final String propertyLink;

    public PropertySupplierPropertyImpl(int startNumber, int endNumber, String propertyLink, ResourceExtractor resourceExtractor) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.propertyLink = propertyLink;
        this.resourceExtractor = resourceExtractor;
        initProperties();
    }

    @PostConstruct
    public void initProperties() {
        properties = resourceExtractor.resourceMappingFromFile(propertyLink);
    }

    @Override
    public int getMaxRoll() {
        return endNumber;
    }

    @Override
    public String getPropertyDetails() {
        return getName() + ", " + getString(getRoll());
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

    @Override
    public String getName() {
        String[] split = propertyLink.split("/");
        String name = split[split.length-1];
        return StringUtils.capitalize(name.split("\\.")[0]);
    }
}
