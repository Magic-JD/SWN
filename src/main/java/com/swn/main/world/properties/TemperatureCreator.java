package com.swn.main.world.properties;

import org.springframework.stereotype.Component;

@Component
public class TemperatureCreator extends PropertyCreator{

    @Override
    String getName() {
        return "Temperature";
    }
}
