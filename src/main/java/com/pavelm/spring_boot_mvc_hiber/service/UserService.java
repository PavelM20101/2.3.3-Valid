package com.pavelm.spring_boot_mvc_hiber.service;


import com.pavelm.spring_boot_mvc_hiber.entity.User;

import java.util.List;

public interface UserService {
    void deleteUser(int id);

    User getUser(int id);

    void createOrUpdateUser(User user);

    List<User> getAllUsers();
}
