package repository;

import bean.User;

import java.util.List;

public interface UserRepository {
    void insertUse(User user) ;
    User selectUser(Integer id);
    List<User> selectAllUser();
    void deleteUser(Integer id) ;
    void updateUser(User user) ;
    List<User> sortNameUser();
    List<User> searhCountryUser(String search);
    User searchIdUser(Integer id);
}
