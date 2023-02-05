package com.swn.main.creator.pc.skill;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillCreator {

    public FurtherChoices findFurtherChoices(SkillSet skills){
        List<String> available = skills.available();
        List<String> followUp = new ArrayList<>();
        available.remove("All Skills");
        String pending = skills.pending();
        if(pending != null && !pending.isEmpty()){
            if(pending.contains(" or ")){
                followUp = new ArrayList<>(Arrays.stream(pending.split(" or ")).filter(s -> !skills.chosen().contains(s)).toList());
                //pending = null;
            } else if(skills.chosen().contains(pending)){
                available.remove(pending);
            }
        }
        return new FurtherChoices(pending, convertToFurtherChoice(available), convertToFurtherChoice(followUp));
    }

    private List<FurtherChoice> convertToFurtherChoice(List<String> list) {
        return list.stream().map(s -> new FurtherChoice(s, null)).collect(Collectors.toList());
    }
}
