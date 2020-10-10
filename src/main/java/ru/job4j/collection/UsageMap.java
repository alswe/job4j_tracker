package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> table = new HashMap<>();
        table.put("johnnycash@mail.com", "Johnny Cash");
        table.put("nathalieportman@mail.com", "Nathalie Portman");
        table.put("drake@mail.com", "Drake");
        table.put("avrillavigne@mail.com", "Avril Lavigne");
        for (Map.Entry<String, String> current : table.entrySet()) {
            System.out.println(current.getKey() + " - " + current.getValue());
        }
    }
}
