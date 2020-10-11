package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            int check = Character.compare(left.charAt(i), right.charAt(i));
            if (check != 0) {
                return check;
            }
        }
        if (left.length() > right.length()) {
            return 1;
        } else if (left.length() < right.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}