package org.example;

import java.sql.*;

//Tworzenie nowej tabeli w bazie danych
public class JDBC_drop_table {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
             connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");

            if(connection==null){
                System.out.println("No connection to the data base");
            }else {
                System.out.println("Is connection");
            }

            statement=connection.createStatement();

            String sql = "DROP TABLE books";  //Zapytanie SQL usuwajace tabelę

            statement.executeUpdate(sql);  //usuniecie tabeli z bazy danych



        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
               // resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }


            try {
                statement.close();              //prawdłowo zamyka się: resultSet potem statement potem connection
            }catch (Exception e){
                e.printStackTrace();
            }

           try {
               connection.close();
           }catch (Exception e){
               e.printStackTrace();
           }
        }

    }
}
