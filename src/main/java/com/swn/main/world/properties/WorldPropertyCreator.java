package com.swn.main.world.properties;

import com.swn.main.property.RangedPropertyCreator;
import org.springframework.stereotype.Component;

@Component
public abstract class WorldPropertyCreator extends RangedPropertyCreator {

    @Override
    protected String getFilePackage() {
        return "src/main/resources/random_gen/world";
    }
}
