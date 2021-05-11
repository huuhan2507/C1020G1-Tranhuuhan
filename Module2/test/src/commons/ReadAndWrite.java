package commons;

import models.MobilePhone;
import models.SmartPhone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWrite {
    public void ghiDienThoaiChinhHang(SmartPhone smartPhone) {
        try {
            FileWriter fileWriter = new FileWriter( "src/data/smartphone.csv", true );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.write( smartPhone.toString() );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ghiDienThoaiXachTay(MobilePhone mobilePhone) {
        try {
            FileWriter fileWriter = new FileWriter( "src/data/mobilephone.csv", true );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.write( mobilePhone.toString() );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SmartPhone> docDienThoaiChinhHang() {
        List<SmartPhone> smartPhoneList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader( "src/data/smartphone.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayLine;
            while ((line = bufferedReader.readLine()) != null) {
                arrayLine = line.split( "," );
                SmartPhone smartPhone = new SmartPhone( Integer.parseInt( arrayLine[0] ), arrayLine[1], arrayLine[2],
                        arrayLine[3], arrayLine[4], arrayLine[5], arrayLine[6] );
                smartPhoneList.add( smartPhone );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smartPhoneList;
    }

    public List<MobilePhone> docDienThoaiXachTay() {
        List<MobilePhone> mobilePhoneList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader( "src/data/mobilephone.csv" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayLine;
            while ((line = bufferedReader.readLine()) != null) {
                arrayLine = line.split( "," );
                MobilePhone mobilePhone = new MobilePhone( Integer.parseInt( arrayLine[0] ), arrayLine[1], arrayLine[2],
                        arrayLine[3], arrayLine[4], arrayLine[5], arrayLine[6] );
                mobilePhoneList.add( mobilePhone );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobilePhoneList;
    }

    public void ghiDienThoai(){
        List<Object> objectList = new ArrayList<>(  );
        objectList.addAll( docDienThoaiChinhHang() );
        objectList.addAll( docDienThoaiXachTay() );
        try {
            FileWriter fileWriter = new FileWriter( "src/data/mobiles.csv" );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            for (Object element: objectList) {
                bufferedWriter.write( element.toString() );
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
