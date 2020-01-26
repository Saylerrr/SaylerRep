package ru.exam;

import java.util.List;

public interface UserDao {
    Users getUser(int id);
    boolean setUser(Users user);
    List<Users> getUsersList(String name);
}
