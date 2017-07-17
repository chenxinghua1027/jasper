package com.pcms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static String driverClassName ="com.mysql.jdbc.Driver";  
    private static String username="root";  
    private static String password="root";  
    private static String url="jdbc:mysql://localhost:3306/pcms?useUnicode=true&characterEncoding=UTF-8";  
      
    static{  
        try {  
            Class.forName(driverClassName);  
        } catch (ClassNotFoundException e) {  
            throw new RuntimeException(e);  
        }  
    }  
      
    public static Connection getConnection(){  
        try {  
            return DriverManager.getConnection(url, username, password);  
        } catch (SQLException e) {  
            throw new RuntimeException(e);  
        }  
    }  
}
