package Helpers;

import java.util.ArrayList;
import java.util.List;

import Models.User;

public class Helper {
    public static List<User> createDummyUsers(int noOfUsers) {
        List<User> users = new ArrayList<User>();
        for (int i = 1; i <= noOfUsers; i++)
            users.add(new User("u" + i));
        return users;
    }
}
