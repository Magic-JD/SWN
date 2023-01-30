package com.swn.main.resourceextractor;

import com.swn.main.property.Property;
import com.swn.main.property.PropertyImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ResourceExtractor {

    public List<Property> rangedResourceMapping(String resourceName) {
        List<Property> properties = new ArrayList<>();
        Consumer<String> consumer = string -> {
            String[] split = string.split("\\|");
            split[0] = split[0].trim();
            if (split[0].contains("-")) {
                String[] numbers = split[0].split("-");
                properties.add(new PropertyImpl(split[1], Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])));
            } else {
                properties.add(new PropertyImpl(split[1], Integer.parseInt(split[0])));
            }
        };
        handleCase(resourceName, consumer);
        return properties;
    }

    public List<Property> nonRangedResourceMapping(String resourceName) {
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = list::add;
        handleCase(resourceName, consumer);
        return IntStream.range(0, list.size())
                .boxed()
                .map(i -> new PropertyImpl(list.get(i), i))
                .collect(Collectors.toList());
    }

    private void handleCase(String resourceName, Consumer<String> handleLine) {
        try (Scanner scanner = new Scanner(new File(resourceName))) {
            while (scanner.hasNext()) {
                handleLine.accept(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
