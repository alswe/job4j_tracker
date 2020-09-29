package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;


public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", item.getId() + "", replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", item.getId() + "", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator() +
                        "=== Exiting the program ===" + System.lineSeparator()));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));

        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Showing all the items ===" + System.lineSeparator() +
                        "id = 1, name = Item 1" + System.lineSeparator() +
                        "id = 2, name = Item 2" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Exiting the program ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));

        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Looking for an item by id ===" + System.lineSeparator() +
                        "id = 1, name = Item 1" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Exiting the program ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item 1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));

        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Looking for an item by name ===" + System.lineSeparator() +
                        "id = 1, name = Item 1" + System.lineSeparator() +
                        "id = 2, name = Item 1" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Exiting the program ===" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"8", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator() +
                        "Wrong input, you can select: 0 .. 0" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator() +
                        "=== Exiting the program ===" + System.lineSeparator()));
    }
}