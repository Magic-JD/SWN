package com.swn.main.generator.beast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeastCreator {

    @Autowired BeastDisplayProperties beast;

    public String createBeast() {
        return beast.displayProperties();
    }

}