package com.swn.main.generator.npc.universal.properties;

import com.swn.main.generator.npc.universal.UniversalNpcPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public class Reaction extends UniversalNpcPropertySupplier {
    @Override
    protected int getDiceNumber() {
        return 2;
    }
}
