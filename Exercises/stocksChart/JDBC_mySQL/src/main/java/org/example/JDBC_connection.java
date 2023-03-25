package org.example;

import java.sql.*;

public class JDBC_connection {
    public static void main(String[] args) {
        Connection connection=null;

        try{
             connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");

            if(connection==null){
                System.out.println("No connection to the data base");
            }else {
                System.out.println("Is connection");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           try {
               connection.close();
           }catch (Exception e){
               e.printStackTrace();
           }
        }

    }
}
