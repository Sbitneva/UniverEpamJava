package app.entities;

import java.io.BufferedReader;
import java.io.FileReader;

public class BookReader {
    public static String read(String path){
        String bookText = new String();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
                line = br.readLine();
            }
            bookText = sb.toString();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return bookText;
    }
}
