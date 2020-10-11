package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.isEmpty()) {
                    start += el;
                } else {
                    start += "/" + el;
                }
                tmp.add(start);
            }
        }
        List<String> result = new ArrayList<>(tmp);
        sortAsc(result);
        return result;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs, Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}