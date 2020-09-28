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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.size);
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[this.size];
        int j = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.items[i].getName().equals(key)) {
                foundItems[j] = this.items[i];
                j++;
            }
        }
        foundItems = Arrays.copyOf(foundItems, j);
        return foundItems;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        this.items[index] = item;
        this.items[index].setId(id);
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        this.items[index] = null;
        System.arraycopy(this.items, index + 1, this.items, index, this.size - 1 - index);
        this.items[this.size - 1] = null;
        this.size--;
        return true;
    }
}