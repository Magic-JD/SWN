package com.swn.main.creator.pc.origin;

import com.swn.main.property.PropertyInfo;
import com.swn.main.property.display.DisplayProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OriginDisplayProperties extends DisplayProperties<OriginPropertySupplier> {

    public List<PropertyInfo> findPropertyInfo(String s) {
        return properties
                .stream()
                .flatMap(ps -> ps.getPropertyBasedOnString(s).stream())
                .collect(Collectors.toList());
    }
}
