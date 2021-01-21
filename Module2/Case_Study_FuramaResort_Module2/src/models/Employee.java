package models;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Employee {
    private String id;

    private String name;
    private String birthDay;
    private String cardId;
    private String phoneNumber;
    private String email;
    private String level;
    private String location;
    private String salary;
    private String age;
    private String address;


    public Employee(String name, String birthDay, String cardId, String phoneNumber, String email, String level, String location, String salary, String age, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.location = location;
        this.salary = salary;
        this.age = age;
        this.address = address;
    }

    public Employee(String id, String name, String birthDay, String cardId, String phoneNumber, String email, String level, String location, String salary,
                    String age, String address) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.location = location;
        this.salary = salary;
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + address;
    }
}
