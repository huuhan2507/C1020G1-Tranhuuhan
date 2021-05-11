package ss16_io_text_file.exercise.nation;

import java.io.BufferedReader;
import java.io.FileReader;

public class Nation {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader( "src/ss16_io_text_file/exercise/nation/nation.txt" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            String line;
            String[] arrayNation;
            while ((line = bufferedReader.readLine())!=null){
                arrayNation=line.split( "," );
                System.out.println("Code Nation: "+ arrayNation[4] + "\t"+ "Name Nation: "+arrayNation[5]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
