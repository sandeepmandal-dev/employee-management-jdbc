package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
   private static final String URL="jdbc:postgresql://localhost:5432/employee_db";
   private static final String Uname="postgre";
   private static final String Password="Password";

    Connection con;

    {
        try {
            con = DriverManager.getConnection(URL,Uname,Password);
            System.out.println("Database connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
