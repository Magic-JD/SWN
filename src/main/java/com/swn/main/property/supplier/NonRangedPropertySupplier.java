package com.swn.main.property.supplier;


import com.swn.main.dice.Dice;
import com.swn.main.property.Property;

import java.util.List;

public abstract class NonRangedPropertySupplier extends PropertySupplierImpl {

    @Override
    protected List<Property> supplyProperties(){
        return resourceExtractor.nonRangedResourceMapping(getFile());
    }

    @Override
    protected int getRoll() {
        return Dice.roll1DN(properties.size());
    }
}
