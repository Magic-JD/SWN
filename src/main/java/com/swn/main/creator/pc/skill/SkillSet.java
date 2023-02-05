package com.swn.main.creator.pc.skill;

import java.util.List;

public record SkillSet(List<String> chosen, String pending, List<String> available) {
}
