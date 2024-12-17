package com.gmail.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    private static Connection con=null;
    private static final String URL="jdbc:mysql://localhost:3306/empleado";
    private static final String USER="root";
    private static final String PASS="";
    public static Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
        } catch (Exception e) {
            System.err.println("Error:"+e);
            
        }
        return con;
    }
}
