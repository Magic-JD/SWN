package com.swn.main.resourceextractor;

import com.swn.main.property.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResourceExtractor {

    public String fullResource(String resourceName){
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream in = getClass().getResourceAsStream(resourceName); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            reader.lines().forEach(s -> {
                stringBuilder.append(s);
                stringBuilder.append("\n");
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return stringBuilder.toString();
    }

    public List<Property> resourceMappingFromString(String string){
        List<Property> properties = new ArrayList<>();
        int count = 1;
        for (String s : string.split(System.lineSeparator())){
            addLineToProperties(properties, count, null, s);
            count++;
        }
        return properties;
    }

    public List<Property> resourceMappingFromFile(String resourceName) {
        List<Property> properties = new ArrayList<>();
        try (InputStream in = getClass().getResourceAsStream(resourceName); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            var lines = reader.lines().toArray(String[]::new);
            for (int i = 0; i < lines.length; i++) {
                addLineToProperties(properties, i+1, resourceName, lines[i]);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    private void addLineToProperties(List<Property> properties, int count, String resourceName, String line){
        if (line.startsWith("PSP")) {
            properties.add(psp(count, line, resourceName));
        } else if (line.startsWith("DPP")) {
            properties.add(dpp(count, line, resourceName));
        } else if (line.contains("|")) {
            properties.add(ranged(line));
        } else {
            properties.add(fromString(count, line));
        }
    }

    private Property dpp(int count, String line, String resourceName) {
        String[] split = line.split("\\|");
        String filePath = resourceName.replace(".txt", "/");
        List<String> filePathExtension = Arrays.stream(split[1].trim().split(","))
                .map(String::trim)
                .map(s -> filePath + s)
                .collect(Collectors.toList());
        return new DisplayPropertyPropertyImpl(count, count, filePathExtension, this);
    }

    private Property psp(int count, String line, String resourceName) {
        String[] split = line.split("\\|");
        String filePath = resourceName.replace(".txt", "/");
        String filePathExtension = split[1].trim();
        return new PropertySupplierPropertyImpl(count, count, filePath + filePathExtension, this);
    }

    private Property ranged(String string) {
        String[] split = string.split("\\|");
        split[0] = split[0].trim();
        if (split[0].contains("-")) {
            String[] numbers = split[0].split("-");
            return fromString(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), split[1].trim());
        } else {
            return fromString(Integer.parseInt(split[0]), split[1].trim());
        }
    }

    private Property fromString(int number, String descriptionString) {
        return fromString(number, number, descriptionString);
    }

    private Property fromString(int startNumber, int endNumber, String descriptionString) {
        String[] split = descriptionString.split(";");
        String description = split[0];
        if (split.length == 1) {
            return new PropertyImpl(description, startNumber, endNumber);
        } else {
            String dice = split[1].trim();
            String[] values = dice.split("d");
            int repeating = Integer.parseInt(values[0]);
            int rollMax = Integer.parseInt(values[1]);
            return new RepeatingProperty(repeating, rollMax, description, startNumber, endNumber);
        }
    }
}
