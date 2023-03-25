package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class JSONExchangeRates {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://v6.exchangerate-api.com/v6/7e39ed7f78789ba20a36d0f9/latest/USD");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        if(connection.getResponseCode() !=200){
            System.out.println("Not 200 response, quit");
            return;
        }

        BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String str;
        StringBuffer stringBuffer= new StringBuffer();

        while ((str=reader.readLine())!=null){
            stringBuffer.append(str);
        }

        String jsonStr = stringBuffer.toString();
        System.out.println(jsonStr);

        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONObject rates = jsonObject.getJSONObject("conversion_rates");
        String dateStr = jsonObject.getString("time_last_update_utc");
        System.out.println("Rates date: "+dateStr);
        System.out.println("Base"+jsonObject.getString("base_code"));

        Map<String,Object> objectMap= rates.toMap();

        objectMap.forEach((k,v)-> System.out.println(k+" : "+v));
        System.out.println(objectMap.get("PLN"));


        reader.close();
    }
}
