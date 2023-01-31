package com.swn.main.npc.universal.properties.name;

import com.swn.main.dice.Dice;
import com.swn.main.npc.standard.properties.StandardNpcPropertySupplier;
import com.swn.main.npc.universal.properties.UniversalNpcPropertySupplier;
import com.swn.main.npc.universal.properties.name.properties.EthnicNamePropertySupplier;
import com.swn.main.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class Name extends UniversalNpcPropertySupplier {

    @Autowired List<EthnicNamePropertySupplier> nameGroups;

    @Override protected void initProperties(){}

    @Override public String getPropertyDetails(){
        return getName() + ": " + nameGroups.get(Dice.roll1DN(nameGroups.size())-1).getPropertyDetails();
    }
}
