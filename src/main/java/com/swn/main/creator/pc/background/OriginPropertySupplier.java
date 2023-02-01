package com.swn.main.creator.pc.background;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class OriginPropertySupplier extends PropertySupplierImpl {


    @Override
    protected String getFilePackage() {
        return "src/main/resources/creator/pc/origin";
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }
}
