package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД

    public Util() {
    }

    public static Connection getConnection() {
        String URL = "jdbc:mysql://localhost:3306/myDbTest";
        String LOGIN = "root";
        String PASSWORD = "12345678";
        Connection conn;

        try {
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if (!conn.isClosed()) {
//                System.out.println("У нас есть соединение;)");
                return conn;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
