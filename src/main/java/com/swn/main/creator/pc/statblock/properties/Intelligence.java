package com.swn.main.creator.pc.statblock.properties;

import com.swn.main.creator.pc.statblock.StatBlockPropertySupplier;
import org.springframework.stereotype.Component;

@Component
public class Intelligence extends StatBlockPropertySupplier {
    @Override
    public int getPriority() {
        return 4;
    }
}
