package com.pavelm.spring_boot_mvc_hiber.service;

import com.pavelm.spring_boot_mvc_hiber.dao.UserDAO;
import com.pavelm.spring_boot_mvc_hiber.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDAO userDAO;
    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        try {
            userDAO.deleteUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void createOrUpdateUser(User user) {
        if (user.getId() == 0) {
            this.createUser(user);
        } else {
            this.updateUser(user);
        }
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
