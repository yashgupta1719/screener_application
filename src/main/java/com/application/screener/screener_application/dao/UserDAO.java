package com.application.screener.screener_application.dao;


import com.application.screener.screener_application.models.User;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    User getUser(Long id);

    User save(User user);

    User update(User user);

    Long deleteUser(Long id);
}
