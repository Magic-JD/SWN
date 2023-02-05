package com.swn.main.creator.pc.skill;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillCreator {

    public FurtherChoices findFurtherChoices(SkillSet skills){
        List<String> available = skills.available();
        available.remove("All Skills");
        if(skills.pending() != null && !skills.pending().isEmpty()){
            if(skills.chosen().contains(skills.pending())){
                available.remove(skills.pending());
            }
        }
        return new FurtherChoices(skills.pending(), skills.available().stream().map(s -> new FurtherChoice(s, null)).collect(Collectors.toList()));
    }
}
