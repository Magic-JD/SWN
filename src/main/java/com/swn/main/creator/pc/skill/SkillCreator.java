package com.swn.main.creator.pc.skill;

import com.swn.main.property.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SkillCreator {

    @Autowired SkillDisplayProperties skillDisplayProperties;

    public FurtherChoices findRollFurtherChoices(SkillSet skills){
        List<String> followUp = new ArrayList<>();
        String pending = skills.pending();
        if(pending.contains(" or ")){
            followUp = Arrays.stream(pending.split(" or ")).filter(ensureNoDuplicates(skills)).toList();
        }
        if(pending.equals("Any Combat")){
            followUp = Stream.of("Shoot", "Stab", "Punch").filter(ensureNoDuplicates(skills)).toList();
        }
        if(pending.equals("Any Skill")){
            followUp = skillDisplayProperties.findAllPropertyInfo().stream().map(PropertyInfo::name).filter(ensureNoDuplicates(skills)).toList();
        }
        int count = Collections.frequency(skills.chosen(), pending);
        if(count == 2 && !pending.startsWith("+")) {
            followUp = skillDisplayProperties.findAllPropertyInfo().stream().map(PropertyInfo::name).filter(ensureNoDuplicates(skills)).toList();
        }
        if(followUp.size() == 1){
            pending = followUp.get(0);
            followUp = new ArrayList<>();
        }
        return new FurtherChoices(pending, new ArrayList<>(), convertToFurtherChoice(followUp));
    }

    public FurtherChoices findFurtherChoices(SkillSet skills){
        Set<String> available = skills.available();
        List<String> followUp = new ArrayList<>();
        available.remove("Any Skill");
        String pending = skills.pending();
        if(pending != null && !pending.isEmpty()){
            if(pending.contains(" or ")){
                followUp = Arrays.stream(pending.split(" or ")).filter(ensureNoDuplicates(skills)).toList();
            }
            if(pending.equals("Any Combat")){
                followUp = Stream.of("Shoot", "Stab", "Punch").filter(ensureNoDuplicates(skills)).toList();
            }
            if(skills.chosen().contains(pending) && !pending.startsWith("+")){
                available.remove(pending);
            }
            int count = Collections.frequency(skills.chosen(), pending);
            if((count == 2 && !pending.startsWith("+") || pending.equals("Special"))) {
                followUp = skillDisplayProperties.findAllPropertyInfo().stream().map(PropertyInfo::name).filter(ensureNoDuplicates(skills)).toList();
            }
        }
        if(followUp.size() == 1){
            pending = followUp.get(0);
            followUp = new ArrayList<>();
        }
        return new FurtherChoices(pending, convertToFurtherChoice(available), convertToFurtherChoice(followUp));
    }

    private Predicate<String> ensureNoDuplicates(SkillSet skills) {
        return s -> skills.chosen().stream().filter(c -> c.equals(s)).count() < 2;
    }

    private List<FurtherChoice> convertToFurtherChoice(Collection<String> coll) {
        return coll.stream().map(s -> new FurtherChoice(s, skillDisplayProperties.findPropertyInfo(s).stream().map(PropertyInfo::details).findFirst().orElse(null))).collect(Collectors.toList());
    }
}
