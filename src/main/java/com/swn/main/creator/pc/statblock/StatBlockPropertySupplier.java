package com.swn.main.creator.pc.statblock;

import com.swn.main.creator.pc.statblock.properties.StatPropertyInfo;
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
        return "/creator/pc/statblock";
    }

    @Override
    protected int getDiceNumber() {
        return 3;
    }

    public StatPropertyInfo getStatBlockInfo(){
        String name = getName();
        int value = getRoll();
        String modString = getString(value);
        int mod = Integer.parseInt(modString.substring(1, modString.length()-1));
        int priority = getPriority();
        return new StatPropertyInfo(name, value, mod, priority);
    }

    abstract public int getPriority();
}
