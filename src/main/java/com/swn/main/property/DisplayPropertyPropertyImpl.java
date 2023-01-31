package com.swn.main.property;

import com.swn.main.property.display.DisplayProperties;
import com.swn.main.property.supplier.PropertySupplier;
import com.swn.main.property.supplier.PropertySupplierImpl;
import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayPropertyPropertyImpl extends DisplayProperties<PropertySupplierImpl> implements Property {

    private int startNumber;
    private int endNumber;

    public DisplayPropertyPropertyImpl(int startNumber, int endNumber, List<String> propertyLink, ResourceExtractor re) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.properties = propertyLink.stream().map(s -> new PropertySupplierImpl() {
            @Override
            protected String getFilePackage() {
                return "";
            }

            @Override
            protected int getDiceNumber() {
                return 1;
            }

            @Override
            public String getPropertyString() {
                int roll = getRoll();
                return getString(roll);
            }

            @PostConstruct
            public void initProperties() {
                properties = re.resourceMapping(s);
            }
        }).collect(Collectors.toList());
        this.properties.forEach(PropertySupplierImpl::initProperties);
    }

    @Override
    public int getMaxRoll() {
        return endNumber;
    }

    @Override
    public String getPropertyDetails(){
        return displayProperties();
    }

    @Override
    public boolean matchesRoll(int roll){
        return roll >= startNumber && roll <= endNumber;
    }

    @Override public List<Integer> provideFurtherRolls(){
        return Collections.emptyList();
    }

    @Override
    public String displayProperties() {
        return properties
                .stream()
                .map(PropertySupplier::getPropertyString)
                .collect(Collectors.joining(" "));
    }
}
