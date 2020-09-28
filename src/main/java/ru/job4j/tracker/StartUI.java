package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Showing all the items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Base is empty");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Editing an item ===");
        int id = Integer.parseInt(input.askStr("Write id of the item to edit: "));
        Item item = new Item(input.askStr("Write new name of the item: "));
        if (tracker.replace(id, item)) {
            System.out.println("The item has been edited");
        } else {
            System.out.println("Something went wrong. The item could not been edited");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Deleting an item ===");
        int id = Integer.parseInt(input.askStr("Write id of the item to delete: "));
        if (tracker.delete(id)) {
            System.out.println("The item has been deleted");
        } else {
            System.out.println("Something went wrong. The item could not been deleted");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        System.out.println("=== Looking for an item by id ===");
        int id = Integer.parseInt(input.askStr("Write id of the item to delete: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("The item with id=" + id + " is not found");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Looking for an item by name ===");
        String name = input.askStr("Write name of the item to delete: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Item with the given name \"" + name + "\" is not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            switch (select) {
                case 0: {
                    StartUI.createItem(input, tracker);
                    break;
                }
                case 1: {
                    StartUI.showAll(tracker);
                    break;
                }
                case 2: {
                    StartUI.editItem(input, tracker);
                    break;
                }
                case 3: {
                    StartUI.deleteItem(input, tracker);
                    break;
                }
                case 4: {
                    StartUI.findItemByID(input, tracker);
                    break;
                }
                case 5: {
                    StartUI.findItemByName(input, tracker);
                    break;
                }
                case 6: {
                    System.out.println("=== Exiting the program ===");
                    run = false;
                    break;
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
