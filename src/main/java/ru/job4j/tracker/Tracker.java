package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[this.size];
        int j = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                itemsWithoutNull[j] = this.items[i];
                j++;
            }
        }
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[this.size];
        int j = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getName() != null && this.items[i].getName().equals(key)) {
                foundItems[j] = this.items[i];
                j++;
            }
        }
        foundItems = Arrays.copyOf(foundItems, j);
        return foundItems;
    }

}