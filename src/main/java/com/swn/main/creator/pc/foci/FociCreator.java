package com.swn.main.creator.pc.foci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FociCreator {

    @Autowired FociExtractor fociExtractor;

    public FociBlock getAllFoci() {
        return new FociBlock(
                Arrays.stream(fociExtractor.getTooltip("foci")
                        .split("\n\n"))
                        .map(this::stringToFociDetails)
                        .collect(Collectors.toList()));
    }

    private FociDetails stringToFociDetails(String s) {
        String[] split = s.split("\n");
        String skill = split[2];
        List<String> skills = Collections.emptyList();
        if(!skill.equals("None")){
            if(skill.equals("Any Combat")) {
                skills = List.of("Punch", "Shoot", "Stab");
            } else if(skill.contains(" or ")){
                skills = Arrays.stream(skill.split(" or ")).collect(Collectors.toList());
            } else {
                skills = List.of(skill);
            }
        }
        return new FociDetails(split[0], split[1], skills, split[3], split[4], split[5]);
    }
}
