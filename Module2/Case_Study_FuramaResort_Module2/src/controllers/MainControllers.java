package controllers;

import another_folder.InputNumber;
import manager.manager_service.AddService;
import manager.manager_service.ShowService;
import manager.ManagerBooking;
import manager.ManagerCustomer;
import manager.ManagerEmployee;
import models.Cinema4D;

public class MainControllers {
    AddService addService = new AddService();
    ShowService showService = new ShowService();
    ManagerCustomer managerCustomer = new ManagerCustomer();
    ManagerBooking managerBooking = new ManagerBooking();
    ManagerEmployee managerEmployee = new ManagerEmployee();
    Cinema4D cinema4D = new Cinema4D();

    public void displayMainMenu() {
        boolean check = true;
        do {
            System.out.println( "*---------------^*Menu*^----------------*" );
            System.out.println( "|      1.Add New Service                |" );
            System.out.println( "|      2.Show Service                   |" );
            System.out.println( "|      3.Add New Customer               |" );
            System.out.println( "|      4.Show Information Of Customer   |" );
            System.out.println( "|      5.Delete Customer                |" );
            System.out.println( "|      6.Edit Customer                  |" );
            System.out.println( "|      7.Add New Booking                |" );
            System.out.println( "|      8.Show Information Of Employee   |" );
            System.out.println( "|      9.Cinema 4D                      |" );
            System.out.println( "|      10.Search Employee               |" );
            System.out.println( "|      11.Exit                          |" );
            System.out.println( "*---------------------------------------*" );
            System.out.println( "What do you want to choose? " );
            int choose = InputNumber.inputInt();
            switch (choose) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showService();
                    break;
                case 3:
                    managerCustomer.addNewCustomer();
                    break;
                case 4:
                    managerCustomer.showInformationCustomer();
                    break;
                case 5:
                    managerCustomer.deleteCustomer();
                    break;
                case 6:
                    managerCustomer.editCustomer();
                    break;
                case 7:
                    managerBooking.addNewBooking();
                    break;
                case 8:
                    managerEmployee.showEmployee();
                    break;
                case 9:
                    cinema4D.menuCinema();
                    break;
                case 10:
                    managerEmployee.searchEmployeeProfile();
                    break;
                case 11:
                    check = false;
                    break;
                default:
                    System.err.println( "The menu item you choose is not available" );
            }
        } while (check);
    }

    public void addNewServices() {
        boolean check = true;
        do {
            System.out.println( "*---------^*Menu*^----------*" );
            System.out.println( "|      1.Add New Villa      |" );
            System.out.println( "|      2.Add New House      |" );
            System.out.println( "|      3.Add New Room       |" );
            System.out.println( "|      4.Back to Menu       |" );
            System.out.println( "|      5.Exit               |" );
            System.out.println( "*---------------------------*" );
            System.out.println( "What do you want to choose? " );
            int choose = InputNumber.inputInt();
            switch (choose) {
                case 1:
                    addService.addNewVilla();
                    break;
                case 2:
                    addService.addNewHouse();
                    break;
                case 3:
                    addService.addNewRoom();
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

    public void showService() {
        boolean check = true;
        do {
            System.out.println( "*----------------^*Menu*^------------------*" );
            System.out.println( "|      1.Show all Villa                    |" );
            System.out.println( "|      2.Show all House                    |" );
            System.out.println( "|      3.Show all Room                     |" );
            System.out.println( "|      4.Show All Name Villa Not Duplicate |" );
            System.out.println( "|      5.Show All Name House Not Duplicate |" );
            System.out.println( "|      6.Show All Name Name Not Duplicate  |" );
            System.out.println( "|      7.Back to Menu                      |" );
            System.out.println( "|      8.Exit                              |" );
            System.out.println( "*------------------------------------------*" );
            System.out.println( "What do you want to choose? " );
            int choose = InputNumber.inputInt();
            switch (choose) {
                case 1:
                    showService.showVilla();
                    break;
                case 2:
                    showService.showHouse();
                    break;
                case 3:
                    showService.showRoom();
                    break;
                case 4:
                    showService.showVillaNotDuplicate();
                    break;
                case 5:
                    showService.showHouseNotDuplicate();
                    break;
                case 6:
                    showService.showRoomNotDuplicate();
                    break;
                case 7:
                    check = false;
                    break;
                case 8:
                    System.exit( 0 );
                    break;
                default:
                    System.err.println( "The menu item you choose is not available" );

            }
        } while (check);
    }
}
