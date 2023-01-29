package com.swn.main.world.properties;

import org.springframework.stereotype.Component;

@Component
public class AtmosphereCreator extends PropertyCreator{

    @Override
    String getName() {
        return "Atmosphere";
    }
}
