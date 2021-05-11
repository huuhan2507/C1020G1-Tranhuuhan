package com.example.service.impl;

import com.example.entity.login.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save( user );
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findUserByUserName( username );
    }

    @Override
    public boolean checkNewPassword(String newPassword, String confirmPassword) {
        return newPassword.equals( confirmPassword );
    }
}
