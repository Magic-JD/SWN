package com.swn.main.creator.npc.universal.properties;

import com.swn.main.creator.npc.universal.UniversalNpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public class Reaction extends UniversalNpcPropertySupplier {
    @Override
    protected int getDiceNumber() {
        return 2;
    }
}
