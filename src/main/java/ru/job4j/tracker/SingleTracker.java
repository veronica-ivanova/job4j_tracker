package ru.job4j.tracker;

public final class SingleTracker {

    private static SingleTracker instance = null;

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean edit(int id, Item item) {
        return tracker.replace(id, item);
    }

    public Item[] findAll() {
        return  tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
