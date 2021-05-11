package manager;

import another_folder.InputNumber;
import commons.ReadAndWriteFile;
import regex_and_exception.exception.*;
import models.Customer;
import regex_and_exception.regex.RegexCustomer;

import java.util.List;
import java.util.Scanner;

public class ManagerCustomer {
    RegexCustomer regexCustomer = new RegexCustomer();
    Scanner scanner = new Scanner( System.in );
    ReadAndWriteFile file = new ReadAndWriteFile();

    public void addNewCustomer() {
        List<Customer> customerList = file.dataCustomer();
        String nameCustomer;
        String birthDayCustomer;
        String genderCustomer;
        String cardIdCustomer;
        String phoneNumber;
        String email;
        String typeCustomer;
        String address;
        do {
            try {
                System.out.println( "Enter Name Customer: " );
                nameCustomer = scanner.nextLine();
                if (regexCustomer.regexName( nameCustomer )) {
                    break;
                }
                throw new NameException( "Client name must capitalize first letter of each word" );
            } catch (NameException e) {
                System.err.println( e.getMessage() );
                System.out.println();
            }
        } while (true);
        do {
            try {
                System.out.println( "Enter birth day customer(format 'dd/mm/yyyy'): " );
                birthDayCustomer = scanner.nextLine();
                if (regexCustomer.regexBirthDay( birthDayCustomer )) {
                    break;
                }
                throw new BirthDayException( "The birth year must be > 1900 and 18 years" +
                        " younger than the current year correct format dd / mm / yyyy.." );
            } catch (BirthDayException e) {
                System.err.println( e.getMessage() );
            }
        } while (true);
        do {

            try {
                System.out.println( "Enter Gender Customer(Male/Female/Unknown): " );
                genderCustomer = scanner.nextLine();
                if (regexCustomer.regexGenderCustomer( genderCustomer )) {
                    break;
                }
                throw new GenderException( "Gender must be Male, Female or Unknown" );
            } catch (GenderException e) {
                System.err.println( e.getMessage() );
                System.out.println();
            }


        } while (true);
        do {
            try {
                System.out.println( "Enter card id customer(format XXX XXX XXX): " );
                cardIdCustomer = scanner.nextLine();
                if (regexCustomer.regexCardIdCustomer( cardIdCustomer )) {
                    break;
                }
                throw new CardIdException( "Id Card must be 9 digits and in the format XXX XXX XXX ." );
            } catch (CardIdException e) {
                System.err.println( e.getMessage() );
                System.out.println();
            }

        } while (true);
        do {
            System.out.println( "Enter phone number(must be '+84 or 0' and 9 number): " );
            phoneNumber = scanner.nextLine();
            if (regexCustomer.regexPhoneNumber( phoneNumber )) {
                break;
            }
            System.err.println( "Phone number invalid" );
            System.out.println();
        } while (true);
        do {
            try {
                System.out.println( "Enter email customer (abc.@abc.abc): " );
                email = scanner.nextLine();
                if (regexCustomer.regexEmailCustomer( email )) {
                    break;
                }
                throw new EmailException( "Email must be in abc@abc.abc format" );
            } catch (EmailException e) {
                System.err.println( e.getMessage() );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "1. Diamond" );
            System.out.println( "2. Platinum" );
            System.out.println( "3. Gold" );
            System.out.println( "4. Silver" );
            System.out.println( "5. Member" );
            int choose = InputNumber.inputInt();
            StringBuilder result = new StringBuilder();
            switch (choose) {
                case 1:
                    result.append( "Diamond" );
                    break;
                case 2:
                    result.append( "Platinum" );
                    break;
                case 3:
                    result.append( "Gold" );
                    break;
                case 4:
                    result.append( "Silver" );
                    break;
                case 5:
                    result.append( "Member" );
                    break;
                default:
            }
            typeCustomer = result.toString();
            if (regexCustomer.regexTypeOfCustomer( typeCustomer )) {
                break;
            }
            System.out.println( "Type of customer invalid" );
            System.out.println();

        } while (true);
        do {
            System.out.println( "Enter address customer" );
            address = scanner.nextLine();
            if (regexCustomer.regexAddress( address )) {
                break;
            }
            System.err.println( "Address customer invalid" );
            System.out.println();
        } while (true);

        System.out.println( "Added Successfully!" );
        Customer customer = new Customer( nameCustomer, birthDayCustomer, genderCustomer, cardIdCustomer, phoneNumber, email,
                typeCustomer, address );
        customerList.add( customer );
        file.customerFile( customer );
    }

    public void showInformationCustomer() {
        List<Customer> customerList = file.dataCustomer();
        if (customerList.isEmpty()) {
            System.err.println( "There is no data to display" );
        } else {
            int count = 1;
            System.out.println( "*---------------------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------*" );
            System.out.printf( "%-7s%-21s%-19s%-15s%-16s%-18s%-30s%-21s%-21s", "NO", "NAME", "BIRTHDAY", "GENDER",
                    "CARD ID", "PHONE NUMBER", "EMAIL CUSTOMER", "TYPE OF CUSTOMER", "ADDRESS" );
            System.out.println();
            System.out.println();
            for (Customer customer : customerList) {
                System.out.printf( "%-7s%-21s%-19s%-15s%-16s%-18s%-30s%-21s%-21s", count++, customer.getName(),
                        customer.getBirthDay(), customer.getGender(), customer.getCardId(), customer.getPhoneNumber(),
                        customer.getEmail(), customer.getTypeCustomer(), customer.getAddress() );
                System.out.println();
            }
            System.out.println( "*---------------------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------*" );
        }
    }

    public void deleteCustomer() {
        int choose;
        List<Customer> customerList = file.dataCustomer();
        if (customerList.size()==0){
            System.err.println("No data display");
            return;
        }
        do {
            showInformationCustomer();
            choose = InputNumber.inputInt()-1;
        }while (choose<0||choose>=customerList.size());
        customerList.remove( choose );
        if (customerList.size()!=0){
            file.customerFileUpdate( customerList.get( 0 ) );
            for (int i = 1; i <customerList.size() ; i++) {
                file.customerFile( customerList.get( i ) );
            }
        }else {
            file.customerFileNull();
        }

    }

    public void editCustomer() {
        List<Customer> customerList = file.dataCustomer();
        showInformationCustomer();
        System.out.println( "Enter the customer location you want to edit: " );
        int choose = InputNumber.inputInt();
        if (choose > 0 && choose <= customerList.size()) {
            editInfoCustomer( choose );
        } else {
            System.err.println( "You entered the wrong data." );
        }
    }

    public void editInfoCustomer(int value) {
        List<Customer> customerList = file.dataCustomer();
        int choose;
        do {
            System.out.println( "1.Name: " + customerList.get( value - 1 ).getName() );
            System.out.println( "2.Birthday: " + customerList.get( value - 1 ).getBirthDay() );
            System.out.println( "3.Card ID: " + customerList.get( value - 1 ).getCardId() );
            System.out.println( "4.Phone Number: " + customerList.get( value - 1 ).getPhoneNumber() );
            System.out.println( "5.Gender: " + customerList.get( value - 1 ).getGender() );
            System.out.println( "6.Email: " + customerList.get( value - 1 ).getEmail() );
            System.out.println( "7.Address " + customerList.get( value - 1 ).getAddress() );
            System.out.println( "8.Type Of Customer: " + customerList.get( value - 1 ).getTypeCustomer() );
            System.out.println( "9. Exit" );
            choose = InputNumber.inputInt();
            switch (choose) {
                case 1:
                    do {
                        System.out.println( "Enter Name Customer: " );
                        String nameCustomer = scanner.nextLine();
                        if (regexCustomer.regexName( nameCustomer )) {
                            customerList.get( choose - 1 ).setName( nameCustomer );
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    do {
                        System.out.println( "Enter birth day customer(format 'dd/mm/yyyy'): " );
                        String birthDayCustomer = scanner.nextLine();
                        if (regexCustomer.regexBirthDay( birthDayCustomer )) {
                            customerList.get( value - 1 ).setBirthDay( birthDayCustomer );
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    do {
                        System.out.println( "Enter card id customer(format XXX XXX XXX): " );
                        String cardIdCustomer = scanner.nextLine();
                        if (regexCustomer.regexCardIdCustomer( cardIdCustomer )) {
                            customerList.get( value - 1 ).setCardId( cardIdCustomer );
                            break;
                        }
                    } while (true);
                    break;
                case 4:
                    do {
                        System.out.println( "Enter phone number(must be '+84 or 0' and 9 number): " );
                        String phoneNumber = scanner.nextLine();
                        if (regexCustomer.regexPhoneNumber( phoneNumber )) {
                            customerList.get( value - 1 ).setPhoneNumber( phoneNumber );
                            break;
                        }
                    } while (true);
                    break;
                case 5:
                    do {
                        System.out.println( "Enter Gender Customer(Male/Female/Unknown): " );
                        String genderCustomer = scanner.nextLine();
                        if (regexCustomer.regexGenderCustomer( genderCustomer )) {
                            customerList.get( value - 1 ).setGender( genderCustomer );
                            break;
                        }
                    } while (true);
                    break;
                case 6:
                    do {
                        System.out.println( "Enter email customer: " );
                        String email = scanner.nextLine();
                        if (regexCustomer.regexEmailCustomer( email )) {
                            customerList.get( value - 1 ).setEmail( email );
                            break;
                        }
                    } while (true);
                    break;
                case 7:
                    do {
                        System.out.println( "Enter address customer" );
                        String address = scanner.nextLine();
                        if (regexCustomer.regexAddress( address )) {
                            customerList.get( value - 1 ).setAddress( address );
                            break;
                        }
                    } while (true);
                    break;
                case 8:
                    do {
                        System.out.println( "1. Diamond" );
                        System.out.println( "2. Platinum" );
                        System.out.println( "3. Gold" );
                        System.out.println( "4. Silver" );
                        System.out.println( "5. Member" );
                        int count = InputNumber.inputInt();
                        StringBuilder result = new StringBuilder();
                        switch (count) {
                            case 1:
                                result.append( "Diamond" );
                                break;
                            case 2:
                                result.append( "Platinum" );
                                break;
                            case 3:
                                result.append( "Gold" );
                                break;
                            case 4:
                                result.append( "Silver" );
                                break;
                            case 5:
                                result.append( "Member" );
                                break;
                            default:
                        }
                        String typeCustomer = result.toString();
                        if (regexCustomer.regexTypeOfCustomer( typeCustomer )) {
                            customerList.get( value - 1 ).setTypeCustomer( typeCustomer );
                            break;
                        }
                        System.out.println( "Type of customer invalid" );
                        System.out.println();
                    } while (true);
                    break;
                case 9:
                    System.out.println();
                    break;
                default:
                    System.err.println("Invalid");
            }
            file.customerFileUpdate( customerList.get( 0 ) );
            for (int i = 1; i < customerList.size(); i++) {
                file.customerFile( customerList.get( i ) );
            }
        } while (choose!=9);


    }
}
