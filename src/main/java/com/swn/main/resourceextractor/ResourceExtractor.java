package com.swn.main.resourceextractor;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class ResourceExtractor {

    public Map<Integer, String> resourceMapping(String resourceName){
        Map<Integer, String> mapping = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(resourceName))) {
            while (scanner.hasNext()){
                String string = scanner.nextLine();
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
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return mapping;
    }
}
