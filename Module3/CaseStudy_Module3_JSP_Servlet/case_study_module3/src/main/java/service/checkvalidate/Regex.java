package service.checkvalidate;

import repository.impl.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Regex {
    public static final String CHECK_EMPLOYEE = "select * from employee where employee_id=?";
    BaseRepository baseRepository = new BaseRepository();
    public static final String REGEX_PHONE_NUMBER = "^(0|84\\+)(90|91)\\d{7}$";
    public static final String REGEX_ID_CARD = "^(\\d{9}|\\d{12})";
    public static final String REGEX_EMAIL = "^\\w+@\\w+[.]\\w+$";
    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)" +
            "(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?" +
            "(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
            "(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String REGEX_INTEGER = "^[-]*\\d+$";
    public static final String REGEX_DOUBLE = "^[-]*\\d+([.]\\d+)?$";


    public boolean checkPhoneNumber(String input) {
        return input.matches( REGEX_PHONE_NUMBER );
    }

    public boolean checkIdCard(String input) {
        return input.matches( REGEX_ID_CARD );
    }

    public boolean checkEmail(String input) {
        return input.matches( REGEX_EMAIL );
    }

    public boolean checkDate(String input) {
        return  input.matches( REGEX_DATE );
    }

    public boolean checkNumberInt(String input) {
        return input.matches( REGEX_INTEGER );
    }

    public boolean checkNumberDouble(String input) {
        return input.matches( REGEX_DOUBLE );
    }

    public boolean checkEmployee(Integer id) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( CHECK_EMPLOYEE );
            preparedStatement.setString( 1, String.valueOf( id ) );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return true;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
