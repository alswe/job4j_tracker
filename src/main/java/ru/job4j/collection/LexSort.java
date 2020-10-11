package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(getInteger(left), getInteger(right));
    }

    private int getInteger(String text) {
        return Integer.parseInt(text.substring(0, text.indexOf('.')));
    }
}