package com.swn.main.creator.pc.skill;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SkillCreator {

    public FurtherChoices findFurtherChoices(SkillSet skills){
        List<String> available = skills.available();
        List<String> followUp = new ArrayList<>();
        available.remove("All Skills");
        String pending = skills.pending();
        if(pending != null && !pending.isEmpty()){
            if(pending.contains(" or ")){
                followUp = Arrays.stream(pending.split(" or ")).filter(ensureNoDuplicates(skills)).toList();
            }
            if(pending.equals("Any Combat")){
                followUp = Stream.of("Shoot", "Stab", "Punch").filter(ensureNoDuplicates(skills)).toList();
            }
            if(skills.chosen().contains(pending)){
                available.remove(pending);
            }
        }
        return new FurtherChoices(pending, convertToFurtherChoice(available), convertToFurtherChoice(followUp));
    }

    private Predicate<String> ensureNoDuplicates(SkillSet skills) {
        return s -> skills.chosen().stream().filter(c -> c.equals(s)).count() < 2;
    }

    private List<FurtherChoice> convertToFurtherChoice(List<String> list) {
        return list.stream().map(s -> new FurtherChoice(s, null)).collect(Collectors.toList());
    }
}
