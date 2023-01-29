package com.swn.main.encounter;

import com.swn.main.encounter.urban.UrbanDisplayProperties;
import com.swn.main.encounter.wilderness.WildernessDisplayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncounterCreator {

    @Autowired UrbanDisplayProperties urban;
    @Autowired WildernessDisplayProperties wilderness;

    public String createUrbanEncounter(){
       return urban.displayProperties();
    }

    public String createWildernessEncounter(){
        return wilderness.displayProperties();
    }
}
