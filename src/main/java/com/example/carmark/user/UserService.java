package com.example.carmark.user;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    User getUser(String username);
    List<User> getAllUsers();

}
