package regex_and_exception.regex;

import models.House;
import models.Room;
import models.Villa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RegexService {
    List<Villa> villaList = new LinkedList<>();
    List<House> houseList = new LinkedList<>();
    List<Room> roomList = new LinkedList<>();

    public boolean checkIdVilla(String idVilla) {
        try {
            FileReader fileReader = new FileReader( "src/data/Villa.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayFile;

            while ((line = bufferedReader.readLine()) != null) {
                arrayFile = line.split( ", " );
                Villa villa = new Villa( arrayFile[0], arrayFile[1], arrayFile[2], arrayFile[3], arrayFile[4], arrayFile[5],
                        arrayFile[6], arrayFile[7], arrayFile[8], arrayFile[9] );
                villaList.add( villa );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (idVilla.matches( "(SVVL-)\\d{4}" )) {
            for (Villa villa : villaList) {
                if (idVilla.equals( villa.getIdService() )) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean checkIdHouse(String idHouse) {
        try {
            FileReader fileReader = new FileReader( "src/data/House.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayFile;

            while ((line = bufferedReader.readLine()) != null) {
                arrayFile = line.split( ", " );
                House house = new House( arrayFile[0], arrayFile[1], arrayFile[2], arrayFile[3], arrayFile[4], arrayFile[5],
                        arrayFile[6], arrayFile[7], arrayFile[8] );
                houseList.add( house );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (idHouse.matches( "(SVHO-)\\d{4}" )) {
            for (House house : houseList) {
                if (idHouse.equals( house.getIdService() )) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean checkIdRoom(String idRoom) {
        try {
            FileReader fileReader = new FileReader( "src/data/House.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayFile;

            while ((line = bufferedReader.readLine()) != null) {
                arrayFile = line.split( ", " );
                Room room = new Room( arrayFile[0], arrayFile[1], arrayFile[2], arrayFile[3], arrayFile[4], arrayFile[5],
                        arrayFile[6] );
                roomList.add( room );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (idRoom.matches( "(SVRO-)\\d{4}" )) {
            for (Room room : roomList) {
                if (idRoom.equals( room.getIdService() )) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean checkAreaService(String area) {
        return area.matches( "([3-9][0-9](\\.[0-9]+)*|[1-9][0-9][0-9]+(\\.[0-9]+)*)" );
    }

    public boolean checkAmountPeople(String amountPeople) {
        return amountPeople.matches( "([1-9]|(1)[0-9])" );
    }

    public boolean checkPriceService(String price) {
        return price.matches( "\\d+" );
    }

    public boolean checkFloor(String floor) {
        return floor.matches( "\\d+" );
    }

    public boolean checkNameService(String name) {
        return name.matches( "[A-Z][a-z]{1,15}" );
    }

    public boolean checkStandardRoom(String standardRoom) {
        return standardRoom.matches( "Normal|Business|Vip" );
    }

    public boolean checkTypeOfRent(String typeOfRent) {
        return typeOfRent.matches( "(Day|Month|Year)" );
    }

    public boolean checkOtherService(String otherService) {
        return otherService.matches( "(Message|Karaoke|Food|Drink|Car)" );
    }
}
