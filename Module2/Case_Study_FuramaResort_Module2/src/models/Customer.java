package models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String birthDay;
    private String cardId;
    private String gender;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private int ticket;
    private int moneyBuyCinema4D;
    Services services;


    public Customer(String name, String birthDay, String gender, String cardId, String phoneNumber, String email,
                    String typeCustomer, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer(String name, String cardId, String phoneNumber, int ticket, int moneyBuyCinema4D) {
        this.name = name;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.ticket = ticket;
        this.moneyBuyCinema4D = moneyBuyCinema4D;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getMoneyBuyCinema4D() {
        return moneyBuyCinema4D;
    }

    public void setMoneyBuyCinema4D(int moneyBuyCinema4D) {
        this.moneyBuyCinema4D = moneyBuyCinema4D;
    }

    public Customer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName1() {
        StringBuilder name1 = new StringBuilder();
        String[] arrayName = name.split( " " );
        name1.append( arrayName[arrayName.length - 1] );
        for (int i = arrayName.length - 2; i >= 0; i--) {
            name1.append( " " );
            name1.append( arrayName[i] );
        }
        return name1.toString();
    }

    public String getYear() {
        return birthDay.substring( 6 );
    }

    public String getMonth() {
        return birthDay.substring( 3, 5 );
    }

    public String getDay() {
        return birthDay.substring( 0, 2 );
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }


    @Override
    public String toString() {
        return name + ", " +
                birthDay + ", " +
                gender + ", " +
                cardId + ", " +
                phoneNumber + ", " +
                email + ", " +
                typeCustomer + ", " +
                address;
    }
}
