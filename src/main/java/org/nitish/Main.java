package org.nitish;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        URL url= null;
        HttpURLConnection connection=null;
        int responseCode=0;
     String StringUrl = "https://api.zippopotam.us/us/33162";

     try{
         url = new URL(StringUrl);
     }
     catch (Exception e){
         System.out.println("Url error");
     }

     try{
     connection = (HttpURLConnection)url.openConnection();
     responseCode=connection.getResponseCode();
     }
     catch(Exception e){
        System.out.println("connection url");
        }

        if(responseCode == 200)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while((readLine = in.readLine())!= null)
            {
                apiData.append(readLine);
            }
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JSONObject jasonAPIResponse = new JSONObject(apiData.toString());


            //System.out.println(JSONObject.getNames("jokes"));


            System.out.println(jasonAPIResponse.toString());
        }
        else
            System.out.println("API call could not be made!!!");



    }
}