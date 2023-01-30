package com.swn.main.beast;

import com.swn.main.npc.patron.PatronDisplayProperties;
import com.swn.main.npc.standard.StandardDisplayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeastCreator {

    @Autowired BeastDisplayProperties beast;

    public String createBeast() {
        return beast.displayProperties();
    }

}