package com.swn.main.creator.pc.origin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class OriginCreator {

    @Autowired OriginDisplayProperties origin;
    @Autowired OriginToolTipExtractor tooltip;

    public String createOrigin() {
        return origin.displayProperties();
    }

    public String originTooltip(String origin){
        return tooltip.getTooltip(origin);
    }

}