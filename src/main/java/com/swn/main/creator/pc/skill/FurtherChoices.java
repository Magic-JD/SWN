package com.swn.main.creator.pc.skill;

import java.util.List;

public record FurtherChoices(String toAdd, List<FurtherChoice> choices, List<FurtherChoice> followUp) {
}
