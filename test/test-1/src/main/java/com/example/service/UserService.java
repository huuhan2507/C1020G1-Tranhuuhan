package com.example.service;

import com.example.model.User;


public interface UserService {
    void updateStatus(Integer userId, Integer statusId);

    User findUserByAccountId(Integer id);

    void updateAvatar(Integer userId, String image, String imageName);

    void updateBackground(Integer userId, String background, String imageName);
}
