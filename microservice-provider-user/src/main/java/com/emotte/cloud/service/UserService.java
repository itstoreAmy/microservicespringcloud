package com.emotte.cloud.service;

import com.emotte.cloud.app.user.emerp.model.User;

public interface UserService {


    int addUser(User user);

    int addUser2(User user);

    int addUser3(User user);

    User getById(Long id);
}
