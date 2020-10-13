package ru.job4j.collection;

import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftArray = left.toLowerCase().toCharArray();
        char[] rightArray = right.toLowerCase().toCharArray();
        Arrays.sort(leftArray);
        Arrays.sort(rightArray);
        return Arrays.equals(leftArray, rightArray);
    }
}