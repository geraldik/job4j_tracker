package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User u: users) {
            if (login.equals(u.getUsername())) {
                rsl = u;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User is not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
       if (!(user.isValid() && user.getUsername().length() > 2)) {
           throw new UserInvalidException("User is not valid");
       }
       return true;
    }

    public static void main(String[] args) {
        User user1 = new User("Petr Arsentev", true);
        User[] users = {
                user1
        };
        try {
                user1 = findUser(users, "Petr Arsentev");
                if (validate(user1)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}