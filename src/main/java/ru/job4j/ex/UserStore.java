package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean rsl = true;
        for (User item : users) {

        }

        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Veronika", true)
        };
        User user = findUser(users, "Veronika");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
    }
}
