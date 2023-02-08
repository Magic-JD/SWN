package com.swn.main.creator.pc.foci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
        return new FociDetails(split[0], split[1], split[2], split[3], split[4]);
    }
}
