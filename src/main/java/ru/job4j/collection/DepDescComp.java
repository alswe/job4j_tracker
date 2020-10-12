package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] departments1 = o1.split("/");
        String[] departments2 = o2.split("/");
        int result = departments2[0].compareTo(departments1[0]);

        if (result == 0) {
            return o1.compareTo(o2);
        } else {
            return result;
        }
    }
}