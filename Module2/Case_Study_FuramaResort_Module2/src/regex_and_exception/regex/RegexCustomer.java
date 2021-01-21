package regex_and_exception.regex;

import commons.ReadAndWriteFile;
import models.Customer;

import java.util.Date;
import java.util.List;

public class RegexCustomer {
    ReadAndWriteFile file = new ReadAndWriteFile();
    public RegexCustomer() {
    }

    //--------------------------------RegexName------------------------------------------------------
    public boolean regexName(String name) {
        return name.matches( "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$" );
        //"([A-Z][a-z]+)(([ ][A-Z][a-z]+)+)$"
    }

    //--------------------------------RegexBirthDay--------------------------------------------------
    public boolean regexBirthDay(String birthDay) {
        if (!birthDay.matches( "^(([0][1-9]|[1-2][0-9]|[3][0-1])/([0][13578]|[1][02])|(0[1-9]|[1-2][0-9]|30)/" +
                "([0][469]|11)|(0[1-9]|[1-2][0-9])/02)/(19\\d{2}|200[0-3])$" )) {
            return false;
        }
        int day = Integer.parseInt( birthDay.substring( 0, 2 ) );
        int month = Integer.parseInt( birthDay.substring( 3, 5 ) );
        int year = Integer.parseInt( birthDay.substring( 6 ) );
        Date now = new Date();
        int yearNow = now.getYear() + 1900;
        int monthNow = now.getMonth() + 1;
        int dayNow = now.getDate();
        if (yearNow - year == 18) {
            if (monthNow < month) {
                return false;
            } else if (month == monthNow) {
                if (dayNow < day) {
                    return false;
                }
            }
        }
        int dayMax;
        switch (month) {
            case 2:
                if (checkLeapYear( year )) {
                    dayMax = 29;
                } else {
                    dayMax = 28;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayMax = 31;
                break;
            default:
                dayMax = 30;
        }
        return day >= 1 && day <= dayMax;
    }

    public boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }//function of RegexBirthDay

    //---------------------------------RegexCardID----------------------------------------------------

    public boolean regexCardIdCustomer(String cardId) {
        List<Customer> customerList = file.dataCustomer();
        if (cardId.matches( "\\d{3}(([ ]\\d{3}){2})" )){
            for (Customer element:customerList) {
                if (element.getCardId().equals( cardId )){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //--------------------------------RegexPhoneNumber--------------------------------------------------

    public boolean regexPhoneNumber(String phoneNumber) {
        return phoneNumber.matches( "(\\+84|0)\\d{9}" );
    }

    //--------------------------------RegexGender------------------------------------------------------

    public boolean regexGenderCustomer(String gender) {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder( "" );

        String str = gender.substring( 0, 1 );
        str = str.toUpperCase();

        String str1 = gender.substring( 1 );
        str1 = str1.toLowerCase();

        stringBuilder.append( str );
        stringBuilder.append( str1 );
        String genderString = stringBuilder.toString();

        return genderString.matches( "(Male|Female|Unknown)" );
    }

    //--------------------------------checkEmail-----------------------------------------------------------

    public boolean regexEmailCustomer(String email) {
        return email.matches( "^[a-z0-9]{6,}@[a-z]+\\.[a-z]+" );
    }

    //--------------------------------checkType---------------------------------------------------------

    public boolean regexTypeOfCustomer( String typeOfCustomer) {
        return typeOfCustomer.matches( "(Diamond|Platinum|Gold|Silver|Member)" );
    }

    //---------------------------------checkAddress----------------------------------------------------

    public boolean regexAddress(String address){
        return address.matches( "[A-Z][a-z]+([ ][A-Z][a-z]+)*" );
    }

}
