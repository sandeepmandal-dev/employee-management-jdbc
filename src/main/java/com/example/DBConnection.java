package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
   private static final String URL="jdbc:postgresql://localhost:5432/employee_db";
   private static final String Uname="postgres";
   private static final String Password="Sandy@7079";

   public static Connection getConnection(){
       Connection connection=null;
       try {
           connection=DriverManager.getConnection(URL,Uname,Password);
       }catch (SQLException e){
           e.printStackTrace();
       }
       return connection;
   }


}
