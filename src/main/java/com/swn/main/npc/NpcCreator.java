package com.swn.main.npc;

import com.swn.main.npc.patron.PatronDisplayProperties;
import com.swn.main.npc.standard.StandardDisplayProperties;
import com.swn.main.npc.universal.UniversalNpcDisplayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NpcCreator {
    @Autowired UniversalNpcDisplayProperties universal;
    @Autowired StandardDisplayProperties standard;
    @Autowired PatronDisplayProperties patron;

    public String createStandard() {
        return universal.displayProperties() + "\n" + standard.displayProperties();
    }

    public String createPatron() {
        return universal.displayProperties() + "\n" + standard.displayProperties() + "\n" + patron.displayProperties();
    }
}
