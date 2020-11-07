package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ScopeInside {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(add(array));
    }

    private static int add(int[] array) {
        int total = 0;
        BiFunction<Integer, Integer, Integer> biFunction = (BinaryOperator<Integer>) Integer::sum;
        for (int i = 0; i < array.length; i++) {
            total = biFunction.apply(total, array[i]);
        }
        return total;
    }
}