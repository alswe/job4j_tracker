package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftArray = left.toLowerCase().toCharArray();
        char[] rightArray = right.toLowerCase().toCharArray();

        Map<Character, Integer> leftMap = new HashMap<>();
        for (char currentChar : leftArray) {
            leftMap.put(currentChar, leftMap.getOrDefault(currentChar, 0) + 1);
        }
        for (char currentChar : rightArray) {
            if (leftMap.containsKey(currentChar)) {
                if (leftMap.get(currentChar) == 1) {
                    leftMap.remove(currentChar);
                } else {
                    leftMap.replace(currentChar, leftMap.get(currentChar) - 1);
                }
            }
        }
        return leftMap.isEmpty();
    }
}