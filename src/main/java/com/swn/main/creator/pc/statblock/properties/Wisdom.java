package com.swn.main.creator.pc.statblock.properties;

import com.swn.main.creator.pc.statblock.StatBlockPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public class Wisdom extends StatBlockPropertySupplier {
    @Override
    public int getPriority() {
        return 5;
    }
}
