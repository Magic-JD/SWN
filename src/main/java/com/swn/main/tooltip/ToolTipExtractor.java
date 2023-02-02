package com.swn.main.tooltip;

import com.swn.main.resourceextractor.ResourceExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public abstract class ToolTipExtractor {

    @Autowired ResourceExtractor resourceExtractor;

    public String getTooltip(String tooltipName){
        return resourceExtractor.fullResource(filePath() + tooltipName + ".txt");
    }

    protected abstract String filePath();



}
