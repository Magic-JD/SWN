package com.swn.main.property.supplier;

import com.swn.main.dice.Dice;
import com.swn.main.property.Property;
import com.swn.main.property.PropertyInfo;
import com.swn.main.resourceextractor.ResourceExtractor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class StringPropertySupplierImpl implements PropertySupplier {

    @Autowired protected ResourceExtractor resourceExtractor;
    protected List<Property> properties;

    public StringPropertySupplierImpl(ResourceExtractor resourceExtractor){
        this.resourceExtractor = resourceExtractor;
        initProperties();
    }

    @PostConstruct
    public void initProperties() {
        properties = resourceExtractor.resourceMappingFromString(getStringToBeMapped());
    }

    public abstract String getStringToBeMapped();

    @Override
    public String getPropertyString() {
        int roll = getRoll();
        return getName() + ": " + getString(roll);
    }

    @Override
    public PropertyInfo getPropertyInfo(){
        return new PropertyInfo(getName(), getString(getRoll()));
    }

    protected String getFilePackage(){
        return null;
    }

    protected int getDiceNumber(){
        return 1;
    }

    protected int getRoll() {
        return Dice.rollXDN(getDiceNumber(), properties.stream()
                .mapToInt(Property::getMaxRoll)
                .max()
                .orElseThrow(RuntimeException::new) / getDiceNumber());
    }

    private Stream<Property> getProperties(int roll) {
        return properties
                .stream()
                .filter(property -> property.matchesRoll(roll))
                .findAny()
                .stream()
                .flatMap(property ->
                        Stream.concat(
                                Stream.of(property),
                                property.provideFurtherRolls()
                                        .stream()
                                        .flatMap(this::getProperties)));

    }

    protected String getString(int roll) {
        return getProperties(roll)
                .map(Property::getPropertyDetails)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(" - "));
    }

    protected abstract String getName();

    protected String getFile() {
        return null;
    }
}
