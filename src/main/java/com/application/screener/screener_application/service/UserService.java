package com.application.screener.screener_application.service;

import com.application.screener.screener_application.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);

    User save(User user);

    Long deleteUser(Long id);

    User update(User user);

}
