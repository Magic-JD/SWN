package com.swn.main.creator.pc.skill;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SkillCreator {

    public FurtherChoices findFurtherChoices(SkillSet skills){
        skills.available().remove("Any Skill");
        if(skills.pending() != null && !skills.pending().isEmpty()){
            return new FurtherChoices(skills.pending(), skills.available().stream().map(s -> new FurtherChoice(s, null)).collect(Collectors.toList()));
        } else {
            return new FurtherChoices(null, skills.available().stream().map(s -> new FurtherChoice(s, null)).collect(Collectors.toList()));
        }
    }
}
