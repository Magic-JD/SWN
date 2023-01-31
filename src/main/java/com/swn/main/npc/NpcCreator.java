package com.swn.main.npc;

import com.swn.main.npc.patron.PatronDisplayProperties;
import com.swn.main.npc.standard.StandardDisplayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NpcCreator {
    @Autowired StandardDisplayProperties standard;
    @Autowired PatronDisplayProperties patron;

    public String createStandard() {
        return standard.displayProperties();
    }

    public String createPatron() {
        return standard.displayProperties() + "\n" + patron.displayProperties();
    }
}
