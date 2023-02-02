package com.swn.main.generator.beast;

import com.swn.main.property.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeastCreator {

    @Autowired BeastDisplayProperties beast;

    public List<PropertyInfo> createBeast() {
        return beast.displayPropertyInfo();
    }

}