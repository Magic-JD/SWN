package com.swn.main.property;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class DisplayProperties<T extends Property> {

    @Autowired List<T> properties;

    public String displayProperties() {
        return properties
                .stream()
                .map(Property::getProperty)
                .collect(Collectors.joining("\n"));
    }
}
