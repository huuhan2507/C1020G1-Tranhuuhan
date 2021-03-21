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
    public boolean checkOldPassword(User user, String password) {
        String passwordBC= new BCryptPasswordEncoder(  ).encode( password );
        String passwordUser = new BCryptPasswordEncoder(  ).encode( user.getPassWord() );
        return passwordUser.equals( new BCryptPasswordEncoder(  ).encode( password ) );
    }

    @Override
    public boolean checkNewPassword(String newPassword, String confirmPassword) {
        String newPasswordBC = new BCryptPasswordEncoder(  ).encode( newPassword );
        String confirmPasswordBC = new BCryptPasswordEncoder(  ).encode( confirmPassword );
        return newPasswordBC.equals( confirmPasswordBC );
    }
}
