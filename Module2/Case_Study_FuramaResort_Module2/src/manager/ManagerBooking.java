package manager;

import another_folder.InputNumber;
import commons.ReadAndWriteFile;
import manager.manager_service.ShowService;
import models.*;
import regex_and_exception.regex.RegexCustomer;

import java.util.Date;
import java.util.List;

public class ManagerBooking {
    List<Booking> bookings = ReadAndWriteFile.dataBookingFile();
    ReadAndWriteFile file = new ReadAndWriteFile();
    ShowService showService = new ShowService();

    public void addNewBooking() {
        List<Customer> customerList = file.dataCustomer();
        do {
            int count = 1;
            int choose;
            System.out.println( "*-------------------------------------------*" );
            System.out.printf( "%-5s%-18s%-15s", "NO", "NAME", "CARD ID" );
            System.out.println();
            System.out.println();
            for (Customer element : customerList) {
                System.out.printf( "%-5s%-18s%-15s", count++, element.getName(), element.getCardId() );
                System.out.println();
            }
            System.out.println( "*--------------------------------------------*" );
            System.out.println( "Which customer do you want to booking: " );
            choose = InputNumber.inputInt();
            if (choose > 0 && choose <= customerList.size()) {
                menuBooking( choose );
                break;
            } else {
                System.err.println( "The menu item you choose is not available" );
                System.out.println();
            }
        } while (true);
    }

    public void menuBooking(int value) {
        boolean check = true;
        do {
            System.out.println( "*-------------------*" );
            System.out.println( "|  1.Booking Villa  |" );
            System.out.println( "|  2.Booking House  |" );
            System.out.println( "|  3.Booking Room   |" );
            System.out.println( "|  4.Back to Menu   |" );
            System.out.println( "|  5.Exit           |" );
            System.out.println( "*-------------------*" );
            System.out.println( "What do you want to choose?" );
            int chose = InputNumber.inputInt();
            switch (chose) {
                case 1:
                    bookingVilla( value );
                    break;
                case 2:
                    bookingHouse( value );
                    break;
                case 3:
                    bookingRoom( value );
                    break;
                case 4:
                    check = false;
                    break;
                case 5:
                    System.exit( 0 );
                    break;
                default:
                    System.err.println( "The menu item you choose is not available" );
            }
        } while (check);

    }

    public void bookingVilla(int value) {
        List<Villa> villaList = file.dataVilla();
        List<Customer> customerList = file.dataCustomer();
        do {
            showService.showVilla();
            System.out.println( "Choose service villa" );
            int choose = InputNumber.inputInt();
            System.out.println( "How many days want to rent: " );
            int day = InputNumber.inputInt();
            if (day < 30 && day > 0) {
                if (choose > 0 && choose <= villaList.size()) {
                    String nameCustomer = customerList.get( value - 1 ).getName();
                    String cardIdCustomer = customerList.get( value - 1 ).getCardId();
                    String nameService = villaList.get( choose - 1 ).getNameService();
                    String idService = villaList.get( choose - 1 ).getIdService();
                    int totalMoney = Integer.parseInt( villaList.get( choose - 1 ).getPriceService() ) * day;
                    totalMoney += moneyService( checkService() );
                    Booking booking = new Booking( nameCustomer, cardIdCustomer, nameService, idService, startDate(), endDate( day ), totalMoney );
                    if (bookings.isEmpty()) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else if (checkBookingList( idService ) && checkDateService( endDate( day ) )) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else if (!checkBookingList( idService )) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else {
                        System.err.println( "This service has been reserved" );
                        break;
                    }
                }
                System.err.println( "Service Villa invalid" );
                System.out.println();
            }
            System.out.println( "Rent days must be greater than 0 and less than 30" );
            System.out.println();
        } while (true);

    }

    public void bookingHouse(int value) {
        List<House> houseList = file.dataHouse();
        List<Customer> customerList = file.dataCustomer();
        do {
            showService.showHouse();
            System.out.println( "Choose service house" );
            int choose = InputNumber.inputInt();
            System.out.println( "How many days want to rent: " );
            int day = InputNumber.inputInt();
            if (day > 0 && day <= 30) {
                if (choose > 0 && choose <= houseList.size()) {
                    String nameCustomer = customerList.get( value - 1 ).getName();
                    String cardIdCustomer = customerList.get( value - 1 ).getCardId();
                    String nameService = houseList.get( choose - 1 ).getNameService();
                    String idService = houseList.get( choose - 1 ).getIdService();
                    int totalMoney = Integer.parseInt( houseList.get( choose - 1 ).getPriceService() ) * day;
                    totalMoney += moneyService( checkService() );
                    Booking booking = new Booking( nameCustomer, cardIdCustomer, nameService, idService, startDate(), endDate( day ), totalMoney );
                    if (bookings.isEmpty()) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else if (checkBookingList( idService ) && checkDateService( endDate( day ) )) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else if (!checkBookingList( idService )) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else {
                        System.err.println( "This service has been reserved" );
                        break;
                    }
                }
                System.err.println( "Service House invalid" );
                System.out.println();
            }
            System.out.println( "Rent days must be greater than 0 and less than 30" );
            System.out.println();

        } while (true);

    }

    public void bookingRoom(int value) {
        List<Room> roomList = file.dataRoom();
        List<Customer> customerList = file.dataCustomer();
        do {
            showService.showRoom();
            System.out.println( "Choose service room" );
            int choose = InputNumber.inputInt();
            System.out.println( "How many days want to rent: " );
            int day = InputNumber.inputInt();
            if (day > 0 && day <= 30) {
                if (choose > 0 && choose <= roomList.size()) {
                    String nameCustomer = customerList.get( value - 1 ).getName();
                    String cardIdCustomer = customerList.get( value - 1 ).getCardId();
                    String nameService = roomList.get( choose - 1 ).getNameService();
                    String idService = roomList.get( choose - 1 ).getIdService();
                    int totalMoney = Integer.parseInt( roomList.get( choose - 1 ).getPriceService() ) * day;
                    totalMoney += moneyService( checkService() );
                    Booking booking = new Booking( nameCustomer, cardIdCustomer, nameService, idService, startDate(), endDate( day ), totalMoney );
                    if (bookings.isEmpty()) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else if (checkBookingList( idService ) && checkDateService( endDate( day ) )) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else if (!checkBookingList( idService )) {
                        file.bookingFile( booking.toString() );
                        break;
                    } else {
                        System.err.println( "This service has been reserved" );
                        break;
                    }
                }
                System.err.println( "Service Room invalid" );
                System.out.println();
            }
            System.err.println( "Rent days must be greater than 0 and less than 30" );
            System.out.println();

        } while (true);

    }

    public String startDate() {
        Date now = new Date();
        String dayN;
        String monthN;
        String yearN=""+(now.getYear()+1900);
        if (now.getDate() < 10) {
            dayN = "0" + now.getDate();
        } else {
            dayN = "" + now.getDate();
        }
        if ((now.getMonth() + 1) < 10) {
            monthN = "0" + (now.getMonth() + 1);
        } else {
            monthN = "" + (now.getMonth() + 1);
        }
        return dayN+"/"+monthN+"/"+yearN;
    }

    public String endDate(int day) {
        Date now = new Date();
        String dayL;
        String monthL;
        int dayNow = now.getDate();
        int monthNow = now.getMonth() + 1;
        int yearNow = now.getYear() + 1900;
        int dayMax = getDayMax( monthNow, yearNow );
        int dayLate = dayNow + day;
        if (dayLate > dayMax) {
            dayLate -= dayMax;
            if (monthNow == 12) {
                monthNow = 1;
                yearNow += 1;
            } else {
                monthNow += 1;
            }
        }
        if (dayLate < 10) {
            dayL = "" + "0" + dayLate;
        } else {
            dayL = "" + dayLate;
        }
        if (monthNow < 10) {
            monthL = "" + "0" + monthNow;
        } else {
            monthL = "" + monthNow;
        }
        return dayL + "/" + monthL + "/" + yearNow;
    }

    public int getDayMax(int month, int year) {
        RegexCustomer regexCustomer = new RegexCustomer();
        int dayMax;
        switch (month) {
            case 2:
                if (regexCustomer.checkLeapYear( year )) {
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
        return dayMax;
    }

    public static boolean checkDateService(String day) {
        String[] dateLate = day.split( "/" );
        int dayLate = Integer.parseInt( dateLate[0] );
        int monthLate = Integer.parseInt( dateLate[1] ) - 1;
        int yearLate = Integer.parseInt( dateLate[2] ) - 1900;
        Date date = new Date( yearLate, monthLate, dayLate );
        Date now = new Date();
        return now.getTime() > date.getTime();
    }

    public boolean checkBookingList(String idService) {
        for (Booking element : bookings) {
            if (idService.equals( element.getIdService() )) {
                return true;
            }
        }
        return false;
    }

    public String checkService() {
        String service = null;
        System.out.println( "Would you like to order something more?" );
        System.out.println( "1.Message" );
        System.out.println( "2.Drinks" );
        System.out.println( "3.Food" );
        System.out.println( "4.Karaoke" );
        System.out.println( "5.Car" );
        System.out.println( "6.Exit" );
        System.out.println( "What do you want to choose? " );
        int choose = InputNumber.inputInt();
        switch (choose) {
            case 1:
                service = "Message";
                break;
            case 2:
                service = "Drinks";
                break;
            case 3:
                service = "Food";
                break;
            case 4:
                service = "Karaoke";
                break;
            case 5:
                service = "Car";
                break;
            case 6:
                service = "Exit";
                break;
            default:
                System.err.println( "The menu item you choose is not available" );

        }
        return service;
    }

    public int moneyService(String service) {
        int money = 0;
        int number;
        switch (service) {
            case "Message":
                System.out.println( "How many masseurs do you want ? (200$/1 person) " );
                number = InputNumber.inputInt();
                money = number * 200;
                break;
            case "Drinks":
                System.out.println( "How much do you want Drink ? (150$/1)" );
                number = InputNumber.inputInt();
                money = number * 150;
                break;
            case "Food":
                System.out.println( "How much do you want Food ?(500$/1)" );
                number = InputNumber.inputInt();
                money = number * 500;
                break;
            case "Karaoke":
                System.out.println( "How much do you want Karaoke ?(500$/1)" );
                number = InputNumber.inputInt();
                money = number * 500;
                break;
            case "Car":
                System.out.println( "How much do you want Car? , 200$/1" );
                number = InputNumber.inputInt();
                money = number * 200;
                break;
            case "None":
                money = 0;
                break;
        }
        return money;
    }
}
