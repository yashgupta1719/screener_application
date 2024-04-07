package com.application.screener.screener_application.service;

import com.application.screener.screener_application.dao.UserDAO;
import com.application.screener.screener_application.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> listOfUsers = userDAO.getAllUsers();
        return listOfUsers;
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        userDAO.save(user);
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        userDAO.update(user);
        return user;
    }

    @Override
    @Transactional
    public Long deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }
}
