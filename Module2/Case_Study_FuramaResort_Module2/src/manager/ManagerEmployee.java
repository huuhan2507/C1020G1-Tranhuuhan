package manager;

import commons.ReadAndWriteFile;
import models.Employee;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ManagerEmployee {
    ReadAndWriteFile file = new ReadAndWriteFile();
    Scanner scanner = new Scanner( System.in );

    public void showEmployee() {
        Map<String,Employee> employeeMap = file.dataEmployeeFileMap();
        System.out.println( "*------------------------------------------------*" );
        System.out.printf( "%-7s%-21s%-7s%-16s", "ID", "NAME EMPLOYEE", "AGE", "ADDRESS" );
        System.out.println();
        employeeMap.forEach( (key, value) -> {
            System.out.printf( "%-7s%-21s%-7s%-16s", key, value.getName(), value.getAge(), value.getAddress() );
            System.out.println();
        } );
        System.out.println( "*------------------------------------------------*" );
        System.out.println();
        do {
            System.out.println( "Would you like to see more detail (Yes or No)" );
            String choose = scanner.nextLine();
            choose = choose.toUpperCase();
            if (choose.equals( "YES" )) {
                showInformationEmployee();
                break;
            } else if (choose.equals( "NO" )) {
                break;
            } else {
                System.err.println( "You need enter Yes or No" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
    }

    public void showInformationEmployee() {
        Map<String,Employee> employeeMap = file.dataEmployeeFileMap();
        System.out.println( "*---------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------*" );
        System.out.printf( "%-7s%-21s%-18s%-17s%-15s%-29s%-13s%-13s%-11s%-9s%-13s", "ID", "NAME EMPLOYEE", "BIRTH DAY", "CARD ID", "PHONE",
                "EMAIL EMPLOYEE", "LEVEL", "LOCATION", "SALARY", "AGE", "ADDRESS" );
        System.out.println();
        System.out.println();
        employeeMap.forEach( (key, value) -> {
            System.out.printf( "%-7s%-21s%-18s%-17s%-15s%-29s%-13s%-13s%-11s%-9s%-13s", key, value.getName(), value.getBirthDay(), value.getCardId(), value.getPhoneNumber(),
                    value.getEmail(), value.getLevel(), value.getLocation(), value.getSalary(), value.getAge(), value.getAddress() );
            System.out.println();
        } );
        System.out.println( "*---------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------*" );
        System.out.println();
    }

    public void searchEmployeeProfile() {
        Stack<Employee> employeeStack = file.dataEmployeeFileStack();
        System.out.println( "Enter the employee code you want to find:  " );
        String code = scanner.nextLine();
        searchEmployee( code );
        while (!employeeStack.isEmpty()){
            employeeStack.pop();
        }
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        readAndWriteFile.dataEmployeeFileStack();
    }

    public void searchEmployee(String code) {
        Stack<Employee> employeeStack = file.dataEmployeeFileStack();
        boolean check = true;
        while (!employeeStack.isEmpty()) {
            if (code.equals( employeeStack.peek().getId() )) {
                check = false;
                break;
            }
            employeeStack.pop();
        }
        if (!check) {
            String id = employeeStack.peek().getId();
            String name = employeeStack.peek().getName();
            String dateOfBirth = employeeStack.peek().getBirthDay();
            String cardId = employeeStack.peek().getCardId();
            String phone =employeeStack.peek().getPhoneNumber();
            String email = employeeStack.peek().getEmail();
            String level = employeeStack.peek().getLevel();
            String location = employeeStack.peek().getLocation();
            String salary = employeeStack.peek().getSalary();
            String age = employeeStack.peek().getAge();
            String address = employeeStack.peek().getAddress();
            System.out.println( "*---------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------*" );
            System.out.printf("%-7s%-21s%-18s%-17s%-15s%-29s%-13s%-13s%-11s%-9s%-13s", "ID", "NAME EMPLOYEE", "BIRTH DAY", "CARD ID", "PHONE",
                    "EMAIL EMPLOYEE", "LEVEL", "LOCATION", "SALARY", "AGE", "ADDRESS" );
            System.out.println();
            System.out.println();
            System.out.printf( "%-7s%-21s%-18s%-17s%-15s%-29s%-13s%-13s%-11s%-9s%-13s", id, name, dateOfBirth, cardId, phone, email, level, location,
                    salary, age, address );
            System.out.println();
            System.out.println( "*---------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------*" );
        } else {
            System.err.println( " No information! " );
        }
        System.out.println();
    }

}
