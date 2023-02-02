package com.swn.main.generator.encounter;

import com.swn.main.generator.encounter.urban.UrbanDisplayProperties;
import com.swn.main.generator.encounter.wilderness.WildernessDisplayProperties;
import com.swn.main.property.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EncounterCreator {

    @Autowired UrbanDisplayProperties urban;
    @Autowired WildernessDisplayProperties wilderness;

    public List<PropertyInfo> createUrbanEncounter() {
        return urban.displayPropertyInfo();
    }

    public List<PropertyInfo> createWildernessEncounter() {
        return wilderness.displayPropertyInfo();
    }
}
