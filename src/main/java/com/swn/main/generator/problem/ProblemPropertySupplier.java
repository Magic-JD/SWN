package com.swn.main.generator.problem;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class ProblemPropertySupplier extends PropertySupplierImpl {

    @Override
    protected String getFilePackage() {
        return "src/main/resources/random_gen/problem";
    }

    @Override
    protected int getDiceNumber() {
        return 2;
    }
}
