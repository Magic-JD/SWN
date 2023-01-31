package com.swn.main.property;

import java.util.List;

public interface Property {

    int getMaxRoll();

    String getPropertyDetails();

    boolean matchesRoll(int roll);

    List<Integer> provideFurtherRolls();

}
