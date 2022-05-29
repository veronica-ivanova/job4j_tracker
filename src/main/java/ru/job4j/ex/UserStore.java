package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                rsl = user;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User is not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
       boolean rsl = user.isValid();
        if (rsl == false && user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Veronika", true)
        };
        try {
            User user = findUser(users, "Veronika");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
