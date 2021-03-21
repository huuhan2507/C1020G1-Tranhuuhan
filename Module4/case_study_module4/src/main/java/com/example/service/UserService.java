package com.example.service;

import com.example.entity.login.User;

public interface UserService {
    void save(User user);

    User findByUserName(String username);


    boolean checkNewPassword(String newPassword, String confirmPassword);
}
