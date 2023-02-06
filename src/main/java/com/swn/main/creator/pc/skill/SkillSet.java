package com.swn.main.creator.pc.skill;

import java.util.List;
import java.util.Set;

public record SkillSet(List<String> chosen, String pending, Set<String> available) {
}
