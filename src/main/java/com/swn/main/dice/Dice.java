package com.swn.main.dice;

import java.util.List;
import java.util.Random;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Dice {
    private static final Random rand = new Random();
    private static final String diceNotation = "(\\d+)?D(\\d+)(\\+(\\d))?";
    private static final Pattern dicePattern = Pattern.compile(diceNotation, Pattern.CASE_INSENSITIVE);

    public static int rollXDN(int x, int n) {
        return rand.ints(1, n + 1)
                .limit(x)
                .sum();
    }

    public static List<Integer> rollXDNNonRepeating(int x, int n) {
        return rand.ints(1, n + 1)
                .distinct()
                .limit(x)
                .boxed()
                .collect(Collectors.toList());
    }

    public static String stringReplace(String s) {
        Matcher diceMatcher = dicePattern.matcher(s);
        return diceMatcher.replaceAll(Dice::strRollDiceMatching);
    }

    private static String strRollDiceMatching(MatchResult result){
        String[] split = result.group().split("[Dd+]");
        int diceRoll = rollXDN(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        if(split.length == 3){
            diceRoll += Integer.parseInt(split[2]);
        }
        return String.valueOf(diceRoll);
    }
}
