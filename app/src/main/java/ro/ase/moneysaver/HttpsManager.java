package ro.ase.moneysaver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpsManager {
    private static String urlAdress;
    BufferedReader reader;
    HttpsURLConnection connection;
    public HttpsManager(String urlAdress) {
        this.urlAdress = urlAdress;
    }
    public String procesare(){
        try {
            return getJsonFromHttps();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            inchidereConexiuni();
        }
    }
private void inchidereConexiuni(){
        try{
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            connection.disconnect();
        }
}
private String getJsonFromHttps() throws IOException {
        connection=(HttpsURLConnection) new URL(urlAdress).openConnection();
        reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder builder=new StringBuilder();
        String line;
        while((line=reader.readLine())!=null){
            builder.append(line);

        }
        return builder.toString();
    }
}
