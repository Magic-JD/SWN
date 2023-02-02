package com.swn.main.creator.pc.statblock;

import com.swn.main.dice.Dice;
import com.swn.main.property.PropertyInfo;
import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

@Component
public abstract class StatBlockPropertySupplier extends PropertySupplierImpl {

    @Override
    public String getPropertyString(){
        int roll = getRoll();
        return getName() + ": " + roll + " " + getString(roll);
    }

    @Override
    public int getRoll(){
        return Dice.rollXDN(getDiceNumber(), 6);
    }

    @Override
    public PropertyInfo getPropertyInfo(){
        int roll = getRoll();
        return new PropertyInfo(getName(), roll + " " + getString(roll));
    }

    @Override
    protected String getFile() {
        return getFilePackage() + "/"  + "statblock.txt";
    }

    @Override
    protected String getFilePackage() {
        return "src/main/resources/creator/pc/statblock";
    }

    @Override
    protected int getDiceNumber() {
        return 3;
    }
}
