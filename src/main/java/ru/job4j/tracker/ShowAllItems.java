package ru.job4j.tracker;

public class ShowAllItems implements UserAction{
    @Override
    public String name() {
        return "Show All items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не заполнено");
        }

        return true;
    }
}
