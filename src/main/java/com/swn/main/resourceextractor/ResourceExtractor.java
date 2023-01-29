package com.swn.main.resourceextractor;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class ResourceExtractor {

    public Map<Integer, String> rangedResourceMapping(String resourceName){
        Map<Integer, String> mapping = new HashMap<>();
        Consumer<String> consumer = string -> {
            String[] split = string.split("\\|");
            split[0] = split[0].trim();
            if(split[0].contains("-")){
                String[] numbers = split[0].split("-");
                for(int i = Integer.parseInt(numbers[0]); i <= Integer.parseInt(numbers[1]); i++){
                    mapping.put(i, split[1]);
                }
            } else {
                mapping.put(Integer.parseInt(split[0]), split[1]);
            }
        };
        handleCase(resourceName, consumer);
        return mapping;
    }

    public List<String> nonRangedResourceMapping(String resourceName){
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = list::add;
        handleCase(resourceName, consumer);
        return list;
    }

    private void handleCase(String resourceName, Consumer<String> handleLine){
        try (Scanner scanner = new Scanner(new File(resourceName))) {
            while (scanner.hasNext()){
                handleLine.accept(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
