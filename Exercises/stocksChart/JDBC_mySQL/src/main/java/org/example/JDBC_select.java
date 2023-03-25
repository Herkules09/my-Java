package org.example;

import java.sql.*;

public class JDBC_select {
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
            String sql="SELECT * FROM employees WHERE salary > 9000 && name LIKE '%ko%' ORDER BY id DESC";  //zapytanie SQL
             resultSet =statement.executeQuery(sql); //wyniki z bazy danych                                 //ASC -sortowanie rosnaco, DESC - malejąco

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
