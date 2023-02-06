package com.swn.main.creator.pc.skill;

import com.swn.main.property.PropertyInfo;
import com.swn.main.property.display.DisplayProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillDisplayProperties extends DisplayProperties<SkillPropertySupplier> {

    public List<PropertyInfo> findPropertyInfo(String s) {
        return properties
                .stream()
                .flatMap(ps -> ps.getPropertyBasedOnString(s).stream())
                .collect(Collectors.toList());
    }

    public List<PropertyInfo> findAllPropertyInfo() {
        return properties
                .stream()
                .flatMap(ps -> ps.getAllProperties().stream())
                .collect(Collectors.toList());
    }
}
