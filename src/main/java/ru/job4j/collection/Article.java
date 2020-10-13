package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.toLowerCase().replaceAll("\\p{Punct}", "");
        line = line.toLowerCase().replaceAll("\\p{Punct}", "");
        Set<String> uniqueOrigin = new HashSet<>(Arrays.asList(origin.split(" ")));
        List<String> lineAsList = new ArrayList<>(Arrays.asList(line.split(" ")));
        int count = 0;
        for (String word : lineAsList) {
            if (uniqueOrigin.contains(word.toLowerCase())) {
                count++;
            }
        }
        return count == lineAsList.size();
    }
}