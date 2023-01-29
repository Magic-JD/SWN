package com.swn.main.world;

import com.swn.main.world.properties.PropertyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorldCreator {

    @Autowired List<PropertyCreator> propertyCreatorList;

    public String getWorld(){
        return propertyCreatorList
                .stream()
                .map(PropertyCreator::getProperty)
                .collect(Collectors.joining("\n"));
    }

}
