package com.swn.main.creator.npc;

import com.swn.main.creator.npc.patron.PatronDisplayProperties;
import com.swn.main.creator.npc.standard.StandardDisplayProperties;
import com.swn.main.creator.npc.universal.UniversalNpcDisplayProperties;
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
