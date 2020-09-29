package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Looking for an item by id ===");
        int id = Integer.parseInt(input.askStr("Write id of the item to delete: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("The item with id=" + id + " is not found");
        }
        return true;
    }
}