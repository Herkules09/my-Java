package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JSONFileParsing {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(new File("example.json")));

        StringBuffer buffer = new StringBuffer();
        String str;
        while ((str=br.readLine()) !=null){
            buffer.append(str);
        }

        String jsonStr=buffer.toString();
        System.out.println(jsonStr);

        JSONObject object =new JSONObject(jsonStr);
        JSONObject company= object.getJSONObject("company");
        System.out.println("Company name: "+company.getString("name"));

        JSONArray arr = company.getJSONArray("products");

        for (int i =0; i<arr.length();i++){
            System.out.println("product: "+arr.getString(i));
        }


    }
}
