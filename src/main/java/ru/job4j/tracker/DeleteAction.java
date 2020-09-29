package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Deleting an item ===");
        int id = Integer.parseInt(input.askStr("Write id of the item to delete: "));
        if (tracker.delete(id)) {
            System.out.println("The item has been deleted");
        } else {
            System.out.println("Something went wrong. The item could not been deleted");
        }
        return true;
    }

}
