package com.swn.main.generator.beast;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class BeastPropertySupplier extends PropertySupplierImpl {

    @Override
    protected String getFilePackage() {
        return "/random_gen/beast";
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }

}
