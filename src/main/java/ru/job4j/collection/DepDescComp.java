package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] departments1 = o1.split("/");
        String[] departments2 = o2.split("/");
        if (departments1[0].equals(departments2[0])) {
            for (int i = 1; i < Math.min(departments1.length, departments2.length); i++) {
                if (!departments1[i].equals(departments2[i])) {
                    return departments1[i].compareTo(departments2[i]);
                }
            }
            if (departments1.length != departments2.length) {
                return Integer.compare(departments1.length, departments2.length);
            }
        }
        return departments2[0].compareTo(departments1[0]);
    }
}