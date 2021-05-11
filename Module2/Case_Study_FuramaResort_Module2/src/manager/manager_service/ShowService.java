package manager.manager_service;

import commons.ReadAndWriteFile;
import models.House;
import models.Room;
import models.Services;
import models.Villa;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ShowService {
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

    public void showVilla() {
        List<Villa> villaList = readAndWriteFile.dataVilla();
        if (villaList.isEmpty()) {
            System.err.println( "There is no data to display" );
        } else {
            int count = 1;
            System.out.println( "*---------------------------------------------------------------------------------------------" +
                    "-------------------------------------------------------------------------------------------*" );
            System.out.printf( "%-5s%-13s%-15s%-20s%-16s%-25s%-16s%-13s%-15s%-17s%-17s", "NO", "ID SERVICE", "NAME SERVICE", "UNIT AREA SERVICE",
                    "AMOUNT", "TYPE OF SERVICE RENTAL ", "PRICE SERVICE", "AREA POOL", "NUMBER FLOOR", "STANDARD ROOM", "OTHER SERVICE" );
            System.out.println();
            System.out.println();
            for (Villa villa : villaList) {
                System.out.printf( "%-5s%-13s%-15s%-20s%-16s%-25s%-16s%-13s%-15s%-17s%-17s", count++, villa.getIdService(), villa.getNameService(), villa.getUnitService(),
                        villa.getAmountPeople(), villa.getDateService(), villa.getPriceService(), villa.getAreaPool(), villa.getNumberFloor(), villa.getStandardRoom(),
                        villa.getOtherService() );
                System.out.println();
            }
            System.out.println( "*---------------------------------------------------------------------------------------------" +
                    "-------------------------------------------------------------------------------------------*" );
        }
    }

    public void showHouse() {
        List<House> houseList = readAndWriteFile.dataHouse();
        if (houseList.isEmpty()) {
            System.err.println( "There is no data to display" );
        } else {
            int count = 1;
            System.out.println( "*---------------------------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------*" );
            System.out.printf( "%-5s%-14s%-15s%-20s%-14s%-25s%-17s%-18s%-17s%-17s", "NO", "ID SERVICE", "NAME SERVICE", "UNIT AREA SERVICE",
                    "AMOUNT", "TYPE OF SERVICE RENTAL ", "PRICE SERVICE", "NUMBER FLOOR", "STANDARD ROOM", "OTHER SERVICE" );
            System.out.println();
            System.out.println();
            for (House house : houseList) {
                System.out.printf( "%-5s%-14s%-15s%-20s%-14s%-25s%-17s%-18s%-17s%-17s", count++, house.getIdService(), house.getNameService(), house.getUnitService(),
                        house.getAmountPeople(), house.getDateService(), house.getPriceService(), house.getNumberFloor(), house.getStandardRoom(),
                        house.getOtherService() );
                System.out.println();
            }
            System.out.println( "*---------------------------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------*" );
        }
    }

    public void showRoom() {
        List<Room> roomList = readAndWriteFile.dataRoom();
        if (roomList.isEmpty()) {
            System.err.println( "There is no data to display" );
        } else {
            int count = 1;
            System.out.println( "*---------------------------------------------------------------------------------------------" +
                    "--------------------------------------------*" );
            System.out.printf( "%-5s%-15s%-16s%-22s%-13s%-26s%-17s%-15s", "NO", "ID SERVICE", "NAME SERVICE", "UNIT AREA SERVICE",
                    "AMOUNT", "TYPE OF SERVICE RENTAL ", "PRICE SERVICE", "FREE SERVICE" );
            System.out.println();
            System.out.println();
            for (Room room : roomList) {
                System.out.printf( "%-5s%-15s%-16s%-22s%-13s%-26s%-17s%-15s", count++, room.getIdService(), room.getNameService(), room.getUnitService(),
                        room.getAmountPeople(), room.getDateService(), room.getPriceService(), room.getFreeService() );

                System.out.println();
            }
            System.out.println( "*---------------------------------------------------------------------------------------------" +
                    "--------------------------------------------*" );
        }

    }

    public void showVillaNotDuplicate() {
        List<Villa> villaList = readAndWriteFile.dataVilla();
        int count = 1;
        Set<String> villaSet = new TreeSet<>();
        for (Services element : villaList) {
            villaSet.add( element.getNameService() );
        }
        System.out.println( "*-------------------------*" );
        System.out.printf( "%-5s%-15s", "NO", "NAME SERVICE" );
        System.out.println();
        System.out.println();
        for (String element : villaSet) {
            System.out.printf( "%-5s%-15s", count++, element );
            System.out.println();
        }
        System.out.println( "*-------------------------*" );
    }

    public void showHouseNotDuplicate() {
        List<House> houseList = readAndWriteFile.dataHouse();
        int count = 1;
        Set<String> houseSet = new TreeSet<>();
        for (Services element : houseList) {
            houseSet.add( element.getNameService() );
        }
        System.out.println( "*-------------------------*" );
        System.out.printf( "%-5s%-15s", "NO", "NAME SERVICE" );
        System.out.println();
        System.out.println();
        for (String element : houseSet) {
            System.out.printf( "%-5s%-15s", count++, element );
            System.out.println();
        }
        System.out.println( "*-------------------------*" );

    }

    public void showRoomNotDuplicate() {
        List<Room> roomList = readAndWriteFile.dataRoom();
        int count = 1;
        Set<String> roomSet = new TreeSet<>();
        for (Services element : roomList) {
            roomSet.add( element.getNameService() );
        }
        System.out.println( "*-------------------------*" );
        System.out.printf( "%-5s%-15s", "NO", "NAME SERVICE" );
        System.out.println();
        System.out.println();
        for (String element : roomSet) {
            System.out.printf( "%-5s%-15s", count++, element );
            System.out.println();
        }
        System.out.println( "*-------------------------*" );
    }

}
