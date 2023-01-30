package com.swn.main.property;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Property {

    int getMaxRoll();

    String getDescription();

    boolean matchesRoll(int roll);

    List<Integer> provideFurtherRolls();

}
