package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item("item");
        LocalDateTime dateTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateTimeFormat = dateTime.format(formatter);
        System.out.println(dateTimeFormat);

        Item item1 = new Item(1, "item1");
        System.out.println(item1);

    }
}
