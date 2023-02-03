package com.swn.main.creator.pc.origin;

import com.swn.main.property.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class OriginCreator {

    @Autowired OriginDisplayProperties origin;
    @Autowired OriginToolTipExtractor tooltip;

    public List<PropertyInfo> createOrigin() {
        return origin.displayPropertyInfo().stream().flatMap(this::updateOriginWithTooltipInformation).collect(Collectors.toList());
    }

    public List<PropertyInfo> findOrigin(String s) {
        return origin.findPropertyInfo(s).stream().flatMap(this::updateOriginWithTooltipInformation).collect(Collectors.toList());
    }

    public String originTooltip(String origin){
        return tooltip.getTooltip(origin);
    }

    private Stream<PropertyInfo> updateOriginWithTooltipInformation(PropertyInfo propertyInfo){
        String name = propertyInfo.details().split(",")[0].toLowerCase();
        String originTooltip = originTooltip(name);
        return Stream.concat(Stream.of(propertyInfo), Arrays.stream(originTooltip.split("\r?\n\r?\n")).skip(1).map(s -> {
            String[] nameDescription = s.split("\n", 2);
            return new PropertyInfo(nameDescription[0], "\n" + nameDescription[1]);
        }));
    }

}