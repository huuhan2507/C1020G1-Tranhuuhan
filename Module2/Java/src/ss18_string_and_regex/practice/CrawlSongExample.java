package ss18_string_and_regex.practice;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL( "https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html" );
            Scanner scanner = new Scanner( new InputStreamReader( url.openStream() ) );
            scanner.useDelimiter( "\\Z" );
            String content = scanner.next();
            scanner.close();
            Pattern p = Pattern.compile( "name_song\">(.*?)</a>" );
            Matcher m = p.matcher( content );
            while (m.find()) {
                System.out.println( m.group( 1 ) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
