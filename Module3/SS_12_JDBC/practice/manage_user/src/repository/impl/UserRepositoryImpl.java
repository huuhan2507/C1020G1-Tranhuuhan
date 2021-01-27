package repository.impl;

import bean.User;
import repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String SELECT_FROM_USERS = "select * from users";
    public static final String DELETE_USER = "delete from users where id = ?";
    public static final String UPDATE_USER = "update users set `name`= ? , email=?, country=? where id = ?";
    public static final String CREAT_USER = "insert into users(`name`,email,country) values (?,?,?)";
    public static final String SELECT_ONE_USER = "select * from users where id = ?";
    public static final String SELECT_SORT_NAME_USER = "select * from users order by `name`";
    public static final String SEARCH_COUNTRY_USER = "select * from users where (country like concat('%',?,'%')) ";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void insertUse(User user) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( CREAT_USER );
            preparedStatement.setString( 1, user.getName() );
            preparedStatement.setString( 2, user.getEmail() );
            preparedStatement.setString( 3, user.getCountry() );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(Integer id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SELECT_ONE_USER );
            preparedStatement.setString( 1, String.valueOf( id ) );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId( id );
                user.setName( resultSet.getString( "name" ) );
                user.setEmail( resultSet.getString( "email" ) );
                user.setCountry( resultSet.getString( "country" ) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SELECT_FROM_USERS );
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId( Integer.parseInt( resultSet.getString( "id" ) ) );
                user.setName( resultSet.getString( "name" ) );
                user.setEmail( resultSet.getString( "email" ) );
                user.setCountry( resultSet.getString( "country" ) );
                userList.add( user );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( DELETE_USER );
            preparedStatement.setString( 1, String.valueOf( id ) );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( UPDATE_USER );
            preparedStatement.setString( 1, user.getName() );
            preparedStatement.setString( 2, user.getEmail() );
            preparedStatement.setString( 3, user.getCountry() );
            preparedStatement.setString( 4, String.valueOf( user.getId() ) );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> sortNameUser() {
        List<User> userList = new ArrayList<>(  );
        try{
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SELECT_SORT_NAME_USER );
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId( Integer.parseInt( resultSet.getString( "id" ) ) );
                user.setName( resultSet.getString( "name" ) );
                user.setEmail( resultSet.getString( "email" ) );
                user.setCountry( resultSet.getString( "country" ) );
                userList.add( user );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> searhCountryUser(String search) {
        List<User> userList = new ArrayList<>( );
        try{
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( SEARCH_COUNTRY_USER);
            preparedStatement.setString( 1,search );
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId( Integer.parseInt( resultSet.getString( "id" ) ) );
                user.setName( resultSet.getString( "name" ) );
                user.setEmail( resultSet.getString( "email" ) );
                user.setCountry( resultSet.getString( "country" ) );
                userList.add( user );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

}
