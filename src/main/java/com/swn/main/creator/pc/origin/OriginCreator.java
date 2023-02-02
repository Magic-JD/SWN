package com.swn.main.creator.pc.origin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class OriginCreator {

    @Autowired OriginDisplayProperties origin;

    public String createOrigin() {
        return origin.displayProperties();
    }

    public String originTooltip(String origin){
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("src/main/resources/tooltip/pc/origin/" + origin + ".txt"))) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

}