package com.swn.main.resourceextractor;

import com.swn.main.property.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class ResourceExtractor {

    public List<Property> resourceMapping(String resourceName) {
        List<Property> properties = new ArrayList<>();
        int count = 1;
        try (Scanner scanner = new Scanner(new File(resourceName))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.startsWith("PSP")) {
                    properties.add(psp(count, line, resourceName));
                } else if (line.startsWith("DPP")) {
                    properties.add(dpp(count, line, resourceName));
                } else if (line.contains("|")) {
                    properties.add(ranged(line));
                } else {
                    properties.add(fromString(count, line));
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    private Property dpp(int count, String line, String resourceName) {
        String[] split = line.split("\\|");
        String filePath = resourceName.replace(".txt", "");
        List<String> filePathExtension = Arrays.stream(split[1].trim().split(","))
                .map(String::trim)
                .map(s -> filePath + s)
                .collect(Collectors.toList());
        return new DisplayPropertyPropertyImpl(count, count, filePathExtension, this);
    }

    private Property psp(int count, String line, String resourceName) {
        String[] split = line.split("\\|");
        String filePath = resourceName.replace(".txt", "");
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
        if (split.length == 1) {
            return new PropertyImpl(split[0], startNumber, endNumber);
        } else {
            String dice = split[1].trim();
            String[] values = dice.split("d");
            int repeating = Integer.parseInt(values[0]);
            int rollMax = Integer.parseInt(values[1]);
            return new RepeatingProperty(repeating, rollMax, split[0], startNumber, endNumber);
        }
    }
}
