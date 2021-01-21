package models;

import another_folder.InputNumber;
import regex_and_exception.regex.RegexCustomer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cinema4D {
    final int CINEMA_TICKET = 500;
    private Queue<Customer> customerQueue = new LinkedList<>();
    private int ticket = CINEMA_TICKET;

    public int ticketCinema() {
        return ticket;
    }

    public void buyTicketCinema(Customer customer, int numberTicket) {
        if (numberTicket < ticketCinema()) {
            customerQueue.add( customer );
            ticket -= numberTicket;
            System.out.println( "You have finished buying your ticket" );
            System.out.println();
        } else if (numberTicket == ticketCinema()) {
            customerQueue.add( customer );
            int count = 1;
            ticket -= numberTicket;
            System.out.println( "You have finished buying your ticket" );
            System.out.println();
            System.out.println( "List Of Customers Who Bought Tickets Today: " );
            System.out.println( "*--------------------------------------------------------------------------------------*" );
            System.out.printf( "%-5s%-19s%-20s%-18s%-9s%-12s", "NO", "NAME CUSTOMER", "CARD ID CUSTOMER", "PHONE NUMBER", "TICKET", "TOTAL MONEY" );
            System.out.println();
            System.out.println();
            for (Customer element : customerQueue) {
                System.out.printf( "%-5s%-19s%-20s%-18s%-9s%-12s", count++, element.getName(), element.getCardId(), element.getPhoneNumber(),
                        element.getTicket(), element.getMoneyBuyCinema4D() );
                System.out.println();
            }
            System.out.println( "*--------------------------------------------------------------------------------------*" );
        }
    }

    public void menuCinema() {
        RegexCustomer regexCustomer = new RegexCustomer();
        Scanner scanner = new Scanner( System.in );
        String name;
        String cardId;
        String phoneNumber;
        int ticket;
        int totalMoney;
        System.out.println( "___________WELCOME TO CINEMA 4D___________" );
        System.out.println();
        if (ticketCinema() == 0) {
            System.err.println( "Out of tickets , please come back later " );
        } else {
            System.out.println( "We currently have " + ticketCinema() + " tickets and 1 ticket is 100$ " );
            do {
                System.out.println( "How many tickets do you want to buy ?" );
                ticket = InputNumber.inputInt();
                if (!(ticket > ticketCinema())) {
                    break;
                }
                System.err.println( "We only have " + ticketCinema() + " tickets" );
            } while (true);
            do {
                System.out.println( "What's your name ?" );
                name = scanner.nextLine();
                if (regexCustomer.regexName( name )) {
                    break;
                }
                System.err.println( "Client name must capitalize first letter of each word " );
                System.out.println();
            } while (true);
            do {
                System.out.println( "Please enter your card id (XXX XXX XXX): " );
                cardId = scanner.nextLine();
                if (regexCustomer.regexCardIdCustomer( cardId )) {
                    break;
                }
                System.err.println( "Enter card id customer(format XXX XXX XXX): " );
                System.out.println();
            } while (true);
            do {
                System.out.println( "Please enter your phone number (+84 or 0 and 9 number) : " );
                phoneNumber = scanner.nextLine();
                if (regexCustomer.regexPhoneNumber( phoneNumber )) {
                    break;
                }
                System.err.println( "Phone number has format +84 or 0 and 9 number " );
                System.out.println();
            } while (true);
            totalMoney = ticket * 100;

            Customer customer = new Customer( name, cardId, phoneNumber, ticket, totalMoney );
            buyTicketCinema( customer, ticket );
        }
    }
}
