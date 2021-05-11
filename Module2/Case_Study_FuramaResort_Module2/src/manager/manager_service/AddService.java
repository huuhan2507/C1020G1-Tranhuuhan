package manager.manager_service;

import commons.ReadAndWriteFile;
import models.House;
import models.Room;
import models.Villa;
import regex_and_exception.regex.RegexService;

import java.util.List;
import java.util.Scanner;

public class AddService {
    Scanner scanner = new Scanner( System.in );

    ReadAndWriteFile file = new ReadAndWriteFile();

    public void addNewVilla() {
        RegexService regexService = new RegexService();
        List<Villa> villaList = file.dataVilla();
        String idService;
        String nameService;
        String areaService;
        String amountPeople;
        String dateService;
        String priceService;
        String areaPool;
        String numberFloor;
        String standardRoom;
        String otherService;
        do {
            System.out.println( "Enter Id Service Villa (SVVL-XXXX): " );
            idService = scanner.nextLine();
            if (regexService.checkIdVilla( idService )) {
                break;
            } else {
                System.err.println( "Id invalid" );
                System.out.println( "Re-enter Id Service: " );
                System.out.println();
            }

        } while (true);
        do {
            System.out.println( "Enter Name Service: " );
            nameService = scanner.nextLine();
            if (regexService.checkNameService( nameService )) {
                break;
            } else {
                System.err.println( "Name invalid" );
                System.out.println( "Re-enter Name Service" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Area Service: " );
            areaService = scanner.nextLine();
            if (regexService.checkAreaService( areaService )) {
                break;
            } else {
                System.err.println( "Area service invalid " );
                System.out.println( "The area you enter must be a real number greater than 30" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Amount People: " );
            amountPeople = scanner.nextLine();
            if (regexService.checkAmountPeople( amountPeople )) {
                break;
            } else {
                System.err.println( "Amount people invalid " );
                System.out.println( "The amount you enter must be positive and less than 20" );
                System.out.println( "Re-enter" );
                System.out.println();
            }

        } while (true);
        do {
            System.out.println( "Enter rental type Service(Day/Month/Year): " );
            dateService = scanner.nextLine();
            if (regexService.checkTypeOfRent( dateService )) {
                break;
            } else {
                System.err.println( "Rental type Service invalid" );
                System.out.println( "You need to enter Day/Month/Year" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Price Service: " );
            priceService = scanner.nextLine();
            if (regexService.checkPriceService( priceService )) {
                break;
            } else {
                System.err.println( "Price service invalid" );
                System.out.println( "price must be greater than 0" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Area Pool : " );
            areaPool = scanner.nextLine();
            if (regexService.checkAreaService( areaPool )) {
                break;
            } else {
                System.err.println( "Area pool service invalid " );
                System.out.println( "The area pool you enter must be a real number greater than 30" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Number Floor Service: " );
            numberFloor = scanner.nextLine();
            if (regexService.checkFloor( numberFloor )) {
                break;
            } else {
                System.err.println( "Number floor service invalid" );
                System.out.println( "Price must be greater than 0" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Standard Room Service (Normal/Business/Vip): " );
            standardRoom = scanner.nextLine();
            if (regexService.checkStandardRoom( standardRoom )) {
                break;
            } else {
                System.err.println( "Standard room invalid" );
                System.out.println( "You need enter Normal / Business/ Vip " );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Other Service (Message/Karaoke/Food/Drink/Car) : " );
            otherService = scanner.nextLine();
            if (regexService.checkOtherService( otherService )) {
                break;
            } else {
                System.err.println( "Other Service invalid" );
                System.out.println( "You need enter Message/Karaoke/Food/Drink/Car" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        System.out.println( "Added Successfully!" );
        Villa villa1 = new Villa( idService, nameService, areaService, amountPeople, dateService, priceService, areaPool, numberFloor, standardRoom, otherService );
        villaList.add( villa1 );
        file.serviceFile( villa1 );
    }

    public void addNewHouse() {
        List<House> houseList = file.dataHouse();
        RegexService regexService = new RegexService();
        String idService;
        String nameService;
        String areaService;
        String amountPeople;
        String dateService;
        String priceService;
        String numberFloor;
        String standardRoom;
        String otherService;
        do {
            System.out.println( "Enter Id Service House (SVHO-XXXX): " );
            idService = scanner.nextLine();
            if (regexService.checkIdHouse( idService )) {
                break;
            } else {
                System.err.println( "Id invalid of Id has already" );
                System.out.println( "Re-enter Id Service: " );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Name Service: " );
            nameService = scanner.nextLine();
            if (regexService.checkNameService( nameService )) {
                break;
            } else {
                System.err.println( "Name invalid" );
                System.out.println( "Re-enter Name Service" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Area Service: " );
            areaService = scanner.nextLine();
            if (regexService.checkAreaService( areaService )) {
                break;
            } else {
                System.err.println( "Area service invalid " );
                System.out.println( "The area you enter must be a real number greater than 30" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Amount People: " );
            amountPeople = scanner.nextLine();
            if (regexService.checkAmountPeople( amountPeople )) {
                break;
            } else {
                System.err.println( "Amount people invalid " );
                System.out.println( "The amount you enter must be positive and less than 20" );
                System.out.println( "Re-enter" );
                System.out.println();
            }

        } while (true);
        do {
            System.out.println( "Enter rental type Service(Day/Month/Year): " );
            dateService = scanner.nextLine();
            if (regexService.checkTypeOfRent( dateService )) {
                break;
            } else {
                System.err.println( "Rental type Service invalid" );
                System.out.println( "You need to enter Day/Month/Year" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Price Service: " );
            priceService = scanner.nextLine();
            if (regexService.checkPriceService( priceService )) {
                break;
            } else {
                System.err.println( "Price service invalid" );
                System.out.println( "price must be greater than 0" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Number Floor Service: " );
            numberFloor = scanner.nextLine();
            if (regexService.checkFloor( numberFloor )) {
                break;
            } else {
                System.err.println( "Number floor service invalid" );
                System.out.println( "Price must be greater than 0" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Standard Room Service: " );
            standardRoom = scanner.nextLine();
            if (regexService.checkStandardRoom( standardRoom )) {
                break;
            } else {
                System.err.println( "Standard room invalid" );
                System.out.println( "You need enter Normal / Business/ Vip " );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Other Service : " );
            otherService = scanner.nextLine();
            if (regexService.checkOtherService( otherService )) {
                break;
            } else {
                System.err.println( "Other Service invalid" );
                System.out.println( "You need enter Message/Karaoke/Food/Drink/Car" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        System.out.println( "Added Successfully!" );
        System.out.println();
        House house1 = new House( idService, nameService, areaService, amountPeople, dateService, priceService, numberFloor, standardRoom, otherService );
        houseList.add( house1 );
        file.serviceFile( house1 );
    }

    public void addNewRoom() {
        RegexService regexService = new RegexService();
        List<Room> roomList = file.dataRoom();
        String nameService;
        String idService;
        String areaService;
        String amountPeople;
        String dateService;
        String priceService;
        String freeService;
        do {
            System.out.println( "Enter Id Service Room (SVRO-XXXX): " );
            idService = scanner.nextLine();
            if (regexService.checkIdRoom( idService )) {
                break;
            } else {
                System.err.println( "Id invalid" );
                System.out.println( "Re-enter Id Service: " );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Name Service: " );
            nameService = scanner.nextLine();
            if (regexService.checkNameService( nameService )) {
                break;
            } else {
                System.err.println( "Name invalid" );
                System.out.println( "Re-enter Id Service: " );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Area Service: " );
            areaService = scanner.nextLine();
            if (regexService.checkAreaService( areaService )) {
                break;
            } else {
                System.err.println( "Area service invalid " );
                System.out.println( "The area you enter must be a real number greater than 30" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Amount People: " );
            amountPeople = scanner.nextLine();
            if (regexService.checkAmountPeople( amountPeople )) {
                break;
            } else {
                System.err.println( "Amount people invalid " );
                System.out.println( "The amount you enter must be positive and less than 20" );
                System.out.println( "Re-enter" );
                System.out.println();
            }

        } while (true);
        do {
            System.out.println( "Enter rental type Service(Day/Month/Year): " );
            dateService = scanner.nextLine();
            if (regexService.checkTypeOfRent( dateService )) {
                break;
            } else {
                System.err.println( "Rental type Service invalid" );
                System.out.println( "You need to enter Day/Month/Year" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Enter Price Service: " );
            priceService = scanner.nextLine();
            if (regexService.checkPriceService( priceService )) {
                break;
            } else {
                System.err.println( "Price service invalid" );
                System.out.println( "price must be greater than 0" );
                System.out.println( "Re-enter" );
                System.out.println();
            }
        } while (true);
        System.out.println( "Added Successfully!" );

        do {
            System.out.println( "Enter free service" );
            freeService = scanner.nextLine();
            if (regexService.checkOtherService( freeService )) {
                break;
            }
            System.out.println( "Free Service Invalid" );
            System.out.println();
        } while (true);
        Room room1 = new Room( idService, nameService, areaService, amountPeople, dateService, priceService, freeService );
        roomList.add( room1 );
        file.serviceFile( room1 );
    }
}
