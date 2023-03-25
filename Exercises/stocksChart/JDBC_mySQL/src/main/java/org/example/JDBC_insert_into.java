package org.example;

import java.sql.*;

public class JDBC_insert_into {
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

            String sqlInsert = "INSERT INTO employees (name ,address, salary) VALUES "   //zapytanie SQL z dodaniem nowych elementow do bazy
                    +"('Rafał Kozak','Bydgoszcz',9500),"
                    +"('Marian Lipiec','Katowice',1100)";

            statement.executeUpdate(sqlInsert);  //dodanie el do bazy danych


            String sqlSelect="SELECT * FROM employees ";  //zapytanie SQL
            resultSet =statement.executeQuery(sqlSelect); //wyniki z bazy danych


            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");

                System.out.println("id:"+id+" "+ "name:"+name+" "+"salary:"+salary);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
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
