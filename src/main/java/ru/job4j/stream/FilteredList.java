package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteredList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = -8; i < 8; i++) {
            numbers.add(i);
        }
        List<Integer> filteredNumbers = numbers.stream().filter(check -> check > 0).collect(Collectors.toList());
        System.out.println(numbers);
        System.out.println(filteredNumbers);
    }
}
