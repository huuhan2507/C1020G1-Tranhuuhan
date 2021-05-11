package service.impl;

import bean.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public void insertUse(User user){
        userRepository.insertUse( user );
    }

    @Override
    public User selectUser(Integer id) {
        return userRepository.selectUser( id );
    }

    @Override
    public List<User> selectAllUser() {
       return userRepository.selectAllUser();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteUser( id );
    }

    @Override
    public void updateUser(User user)  {
        userRepository.updateUser( user );
    }

    @Override
    public List<User> sortNameUser() {
       return userRepository.sortNameUser();
    }

    @Override
    public List<User> searhCountryUser(String search) {
        return userRepository.searhCountryUser(search);
    }



}