package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateStatus(Integer userId, Integer statusId) {
        userRepository.updateStatus( userId, statusId );
    }

    @Override
    public User findUserByAccountId(Integer id) {
        return userRepository.findUserByAccountId( id );
    }

    @Override
    public void updateAvatar(Integer userId, String image, String imageName) {
        if (imageName.equals( "png" ) || imageName.equals( "jpg" )) {
            userRepository.updateAvatar( userId, image );
        }
    }

    @Override
    public void updateBackground(Integer userId, String background, String imageName) {
        if (imageName.equals( "png" ) || imageName.equals( "jpg" )) {
            userRepository.updateBackground( userId, background );
        }
    }
}
