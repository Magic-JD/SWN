package com.swn.main.creator.pc.statblock;

import com.swn.main.property.display.DisplayProperties;
import com.swn.main.property.supplier.PropertySupplierImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatBlockCreator extends DisplayProperties<StatBlockPropertySupplier> {
    public List<String> getAllPropertyNames(){
        return properties.stream().map(PropertySupplierImpl::getName).collect(Collectors.toList());
    }
}
