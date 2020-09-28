package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item());
        tracker.findById(1).setName("book");
        tracker.add(new Item());
        tracker.findById(2).setName("notebook");
        tracker.add(new Item());
        tracker.findById(3).setName("notebook");

        System.out.println(tracker.findById(1).toString());
        System.out.println(Arrays.toString(tracker.findByName("notebook")));
        System.out.println(Arrays.toString(tracker.findAll()));
    }
}
