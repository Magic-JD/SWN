package com.swn.main.property.supplier;


import com.swn.main.dice.Dice;
import com.swn.main.property.Property;

import java.util.List;

public abstract class RangedPropertySupplier extends PropertySupplierImpl {

    @Override
    protected List<Property> supplyProperties(){
        return resourceExtractor.rangedResourceMapping(getFile());
    }

    @Override
    protected int getRoll() {
        return Dice.roll2D6();
    }
}
