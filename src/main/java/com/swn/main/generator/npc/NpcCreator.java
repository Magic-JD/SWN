package com.swn.main.generator.npc;

import com.swn.main.generator.npc.patron.PatronDisplayProperties;
import com.swn.main.generator.npc.standard.StandardDisplayProperties;
import com.swn.main.generator.npc.universal.UniversalNpcDisplayProperties;
import com.swn.main.property.PropertyBlock;
import com.swn.main.property.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class NpcCreator {
    @Autowired UniversalNpcDisplayProperties universal;
    @Autowired StandardDisplayProperties standard;
    @Autowired PatronDisplayProperties patron;

    public List<PropertyInfo> createStandard() {
        return combineLists(List.of(universal.displayPropertyInfo(), standard.displayPropertyInfo()));
    }

    public List<PropertyInfo> createPatron() {
        return combineLists(List.of(universal.displayPropertyInfo(), standard.displayPropertyInfo(), patron.displayPropertyInfo()));
    }

    private List<PropertyInfo> combineLists(List<List<PropertyInfo>> lists){
        return lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
