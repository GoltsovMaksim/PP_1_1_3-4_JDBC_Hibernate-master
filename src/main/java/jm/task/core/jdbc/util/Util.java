package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private String URL = "jdbc:mysql://localhost:3306/myDbTest";
    private String LOGIN = "root";
    private String PASSWORD = "12345678";
    private Connection conn;

    public Util() {
        try {
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if(!conn.isClosed()){
//                System.out.println("У нас есть соединение;)");
            }
        } catch (SQLException e) {
            System.out.println("Что-то не так в классе Util");
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
