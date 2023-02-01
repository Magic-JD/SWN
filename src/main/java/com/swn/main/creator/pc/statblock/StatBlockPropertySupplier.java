package com.swn.main.creator.pc.statblock;

import com.swn.main.dice.Dice;
import com.swn.main.property.supplier.PropertySupplier;
import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class StatBlockPropertySupplier extends PropertySupplierImpl {

    @Override
    public String getPropertyString(){
        int roll = Dice.rollXDN(3, 6);
        return getName() + ": " + roll + " " + getString(roll);
    }

    @Override
    protected String getFile() {
        return getFilePackage() + "/"  + "statblock.txt";
    }

    @Override
    protected String getFilePackage() {
        return "src/main/resources/creator/pc";
    }

    @Override
    protected int getDiceNumber() {
        return 3;
    }
}
