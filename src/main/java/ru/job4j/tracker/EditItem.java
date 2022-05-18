package ru.job4j.tracker;

public class EditItem implements UserAction{
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка заменена успешно");
        } else {
            System.out.println("Ошибка замены заявки");
        }
        return true;
    }
}
