package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void sort() {
        List<Item> items = Arrays.asList(new Item("Third"), new Item("First"), new Item("Second"));
        items.sort(new ItemSort());
        String result = "";
        for (Item item : items) {
            result += item.getName() + " ";
        }
        assertEquals("First Second Third", result.trim());
        items.sort(new ItemReverseSort());
        result = "";
        for (Item item : items) {
            result += item.getName() + " ";
        }
        assertEquals("Third Second First", result.trim());
    }

}