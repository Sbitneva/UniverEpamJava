package homework7.app.entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class URLReader {
    public static String readUrl(URL url) throws Exception{
        //Charset charset = Charset.forName("UTF8");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("User-Agent",
                "62.0.3202.75");
        //connection.setRequestProperty("Accept-Encoding", "identity");
        connection.connect();
        StringBuilder dataFromURL = new StringBuilder();
        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        String str;
        while((str = in.readLine()) != null){
            dataFromURL.append(str);
        }
        in.close();

        return dataFromURL.toString();
    }
}
