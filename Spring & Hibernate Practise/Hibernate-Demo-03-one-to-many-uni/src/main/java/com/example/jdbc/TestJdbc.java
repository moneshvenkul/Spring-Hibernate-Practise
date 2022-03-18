package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSl=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
            System.out.println("connecting to database: "+ jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection Established");
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
