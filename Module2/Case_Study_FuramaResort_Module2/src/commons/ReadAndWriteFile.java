package commons;

import another_folder.SortCustomer;
import models.*;

import java.io.*;
import java.util.*;

public class ReadAndWriteFile {

    final String VILLA_PATH = "src/data/Villa.csv";
    final String HOUSE_PATH = "src/data/House.csv";
    final String ROOM_PATH = "src/data/Room.csv";

    public List<Villa> dataVilla() {
        List<Villa> villaList = new ArrayList<>();
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
        return villaList;
    }

    public List<Room> dataRoom() {
        List<Room> roomList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader( "src/data/Room.csv" );
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
        return roomList;
    }

    public List<House> dataHouse() {
        List<House> houseList = new ArrayList<>();
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
        return houseList;
    }

    public void serviceFile(Object service) {
        if (service instanceof Villa) {
            checkFile( VILLA_PATH, service );
        } else if (service instanceof House) {
            checkFile( HOUSE_PATH, service );
        } else if (service instanceof Room) {
            checkFile( ROOM_PATH, service );
        }
    }

    public void checkFile(String file, Object service) {
        try {
            FileWriter fileWriter = new FileWriter( file, true );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.newLine();
            bufferedWriter.write( service.toString() );
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void customerFile(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter( "src/data/Customer.csv", true );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.write( customer.toString() );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void customerFileUpdate(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter( "src/data/Customer.csv", false );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.write( customer.toString() );
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> dataCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader( "src/data/Customer.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split( ", " );
                Customer customer = new Customer( array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7] );
                customerList.add( customer );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        customerList.sort( new SortCustomer() );
        return customerList;
    }

    public Map<String, Employee> dataEmployeeFileMap() {
        Map<String, Employee> employeeMap = new TreeMap<>();
        try {
            FileReader fileReader = new FileReader( "src/data/Employee.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayFile;
            while ((line = bufferedReader.readLine()) != null) {
                arrayFile = line.split( ", " );
                Employee employee1 = new Employee( arrayFile[1], arrayFile[2], arrayFile[3], arrayFile[4], arrayFile[5], arrayFile[6],
                        arrayFile[7], arrayFile[8], arrayFile[9], arrayFile[10] );
                employeeMap.put( arrayFile[0], employee1 );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeMap;
    }

    public Stack<Employee> dataEmployeeFileStack() {
        Stack<Employee> employeeStack = new Stack<>();
        try {
            FileReader fileReader = new FileReader( "src/data/Employee.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayFile;
            while ((line = bufferedReader.readLine()) != null) {
                arrayFile = line.split( ", " );
                Employee employee2 = new Employee( arrayFile[0], arrayFile[1], arrayFile[2], arrayFile[3], arrayFile[4], arrayFile[5], arrayFile[6],
                        arrayFile[7], arrayFile[8], arrayFile[9], arrayFile[10] );
                employeeStack.push( employee2 );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeStack;
    }

    public void bookingFile(String booking) {
        try {
            FileWriter fileWriter = new FileWriter( "src/data/Booking.csv", true );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.write( booking );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static List<Booking> dataBookingFile() {
        List<Booking> bookingList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader( "src/data/Booking.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayFile;
            while ((line = bufferedReader.readLine()) != null) {
                arrayFile = line.split( ", " );
                Booking booking1 = new Booking( arrayFile[0], arrayFile[1], arrayFile[2], arrayFile[3], arrayFile[4],
                        arrayFile[5], Integer.parseInt( arrayFile[6] ) );
                bookingList.add( booking1 );
            }
        } catch (Exception e) {
            System.out.println();
        }
        return bookingList;
    }

    public void customerFileNull(){
        try {
            FileWriter fileWriter = new FileWriter( "src/data/Customer.csv", false );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.write( "" );
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
