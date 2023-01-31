package com.swn.main.npc.universal.properties.name.properties;

import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class EthnicNamePropertySupplier extends PropertySupplierImpl {

    @Autowired private First first;
    @Autowired private Last last;

   @Override
   public String getPropertyDetails(){
       return first.getPropertyDetails() + " " + last.getPropertyDetails();
   }

   @Override
    protected void initProperties() {}

    @Override
    protected String getFilePackage() {
        return "";
    }

    @Override protected int getDiceNumber(){
        return 0;
    }

}
