package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketDownloadWebPage {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("duckduckgo.com", 80);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        writer.write("GET / HTTP/1.0\n\n");
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String data;

        while ((data = reader.readLine()) != null) {
            System.out.println(data);
        }
    }
}