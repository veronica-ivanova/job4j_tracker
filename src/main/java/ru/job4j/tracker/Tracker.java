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

    public Item[] findAll(){
//        Item[] rsl = new Item[items.length];
//        int newSize = 0;
//        for (int index = 0; index < items.length; index++) {
//            if (items[index] != null) {
//                rsl[newSize] = items[index];
//                newSize++;
//            }
//        }
//        rsl = Arrays.copyOf(rsl, newSize);
//        return rsl;
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                rsl[count] = items[index];
                count++;
            }
        }
        rsl = Arrays.copyOf(rsl, count);
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items[index] = item;
        }
        return result;
    }


//    public static void main(String[] args) {
//        Tracker tracker = new Tracker();
//        Item item = new Item("1");
//        Item item2 = new Item("2");
//        Item item3 = new Item("3");
//
//        tracker.add(item);
//        tracker.add(item2);
//        tracker.add(item3);
//        Item[] ar1 = tracker.findAll();
//        Item[] ar2 = new Item[10];
//        tracker.findByName("2");
//        for (int i = 0; i < tracker.items.length; i++) {
//            System.out.println(tracker.items[i].getName());
//        }
//    }
}