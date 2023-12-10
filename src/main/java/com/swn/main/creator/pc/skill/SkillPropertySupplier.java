package com.swn.main.creator.pc.skill;

import com.swn.main.property.PropertyInfo;
import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public abstract class SkillPropertySupplier extends PropertySupplierImpl {


    @Override
    protected String getFilePackage() {
        return "./src/main/resources/creator/pc/skills";
    }

    @Override
    protected int getDiceNumber() {
        return 1;
    }

    public Optional<PropertyInfo> getPropertyBasedOnString(String s){
        return properties.stream()
                .filter(p -> p.getPropertyDetails().toLowerCase().startsWith(s.toLowerCase()))
                .findFirst().map(p -> new PropertyInfo(getName(), p.getPropertyDetails()));
    }

    public List<PropertyInfo> getAllProperties(){
        return properties.stream()
                .map(p -> new PropertyInfo(p.getPropertyDetails().split(": ")[0], p.getPropertyDetails()))
                .collect(Collectors.toList());
    }
}
