package ss16_io_text_file.exercise.copy_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader( "src/ss16_io_text_file/exercise/copy_file/soucefile.txt" );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            FileWriter fileWriter = new FileWriter( "src/ss16_io_text_file/exercise/copy_file/targetfile.txt" );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write( line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
