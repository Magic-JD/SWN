package com.swn.main.property;

import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PropertyCreator implements Property {

    @Autowired ResourceExtractor resourceExtractor;

    @PostConstruct
    protected abstract void initMapping();

    protected abstract int getRoll();

    protected abstract String getString(int roll);

    @Override
    public String getProperty() {
        int roll = getRoll();
        return getName() + ": " + getString(roll);
    }

    private String getName() {
        return getClass().getSimpleName();
    }

    protected String getFile() {
        return getFilePackage() + "/" + getName().toLowerCase() + ".txt";
    }

    protected abstract String getFilePackage();
}
