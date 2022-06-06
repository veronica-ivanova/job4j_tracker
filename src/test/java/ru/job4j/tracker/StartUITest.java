package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class StartUITest  {
    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
    @Test
    public void whenEditItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String editedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), editedName,  "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(editedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenEditItemOutputSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String editedName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), editedName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenShowAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show All items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + "Item{" + "id=" + one.getId() + ", name='" + one.getName() + '\'' + ", created=" + one.getCreated().format(FORMATTER) +
                        '}' + ln
                        + "Menu:" + ln
                        + "0. Show All items" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", one.getName(), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        System.out.println(out);
        String ln = System.lineSeparator();
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find by name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + "Item{" + "id=" + one.getId() + ", name='" + one.getName() + '\'' + ", created=" + one.getCreated().format(FORMATTER) +
                        '}' + ln
                        + "Menu:" + ln
                        + "0. Find by name" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new Exit()
        };
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        new StartUI(out).init(in, tracker, actions);
        System.out.println(out);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find by Id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + "Item{" + "id=" + one.getId() + ", name='" + one.getName() + '\'' + ", created=" + one.getCreated().format(FORMATTER) +
                        '}' + ln
                        + "Menu:" + ln
                        + "0. Find by Id" + ln
                        + "1. Exit" + ln
        ));
    }
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), Matchers.is(
                        "Menu:" + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0..0" + ln
                                + "Menu:" + ln
                                + "0. Exit" + ln
                )
        );
    }
}