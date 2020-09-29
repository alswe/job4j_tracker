package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Editing an item ===");
        int id = Integer.parseInt(input.askStr("Write id of the item to edit: "));
        Item item = new Item(input.askStr("Write new name of the item: "));
        if (tracker.replace(id, item)) {
            System.out.println("The item has been edited");
        } else {
            System.out.println("Something went wrong. The item could not been edited");
        }
        return true;
    }

}
