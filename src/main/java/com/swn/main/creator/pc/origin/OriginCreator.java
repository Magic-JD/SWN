package com.swn.main.creator.pc.origin;

import com.swn.main.property.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OriginCreator {

    @Autowired OriginDisplayProperties origin;
    @Autowired OriginToolTipExtractor tooltip;

    public List<PropertyInfo> createOrigin() {
        return origin.displayPropertyInfo();
    }

    public List<PropertyInfo> findOrigin(String s) {
        return origin.findPropertyInfo(s);
    }

    public String originTooltip(String origin){
        return tooltip.getTooltip(origin);
    }

}