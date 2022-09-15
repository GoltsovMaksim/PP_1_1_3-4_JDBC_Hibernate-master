package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        Util conn = new Util();
        String sqlQuery = "CREATE TABLE IF NOT EXISTS myDbTest.Users (ID int not null auto_increment key, name varchar(45), lastName varchar(45), age int)";
        try (Statement stat = conn.getConnection().createStatement()) {
            stat.execute(sqlQuery);
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        Util conn = new Util();
        String sqlQuery = "DROP TABLE IF EXISTS myDbTest.Users";
        try (Statement stat = conn.getConnection().createStatement()) {
            stat.executeUpdate(sqlQuery);
//            System.out.println("Таблица Users удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util conn = new Util();
        String sqlQuery = "insert into myDbTest.Users (name, lastName, age) values (\'" + name + "\', \'"+ lastName + "\', \'" + age + "\')";
//        System.out.println(sqlQuery);//закоменти
        try (Statement stat = conn.getConnection().createStatement()) {
            stat.executeUpdate(sqlQuery);
            System.out.println("User с именем " + name +" внесен в таблицу");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        Util conn = new Util();
        String sqlQuery = "DELETE FROM myDbTest.Users WHERE ID =" + id;
        try (Statement stat = conn.getConnection().createStatement()) {
            stat.executeUpdate(sqlQuery);
//            System.out.println("удален User c ID: " + id); //закоменти
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        Util conn = new Util();
        ArrayList <User> al = new ArrayList<>();
        String sqlQuery = "SELECT * FROM myDbTest.Users";
        try (Statement stat = conn.getConnection().createStatement()) {
            ResultSet rs = stat.executeQuery(sqlQuery);
            while (rs.next()) {
                User user = new User();
                user.setId(Long.valueOf(rs.getString("ID")));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(Byte.valueOf(rs.getString("age")));
//                System.out.println(user);//закоменти
                al.add(user);
            }
//            System.out.println(al);
            return al;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        Util conn = new Util();
        String sqlQuery = "DELETE FROM myDbTest.Users";
        try (Statement stat = conn.getConnection().createStatement()) {

            stat.executeUpdate(sqlQuery);
//            System.out.println("удалены  все User from Users"); //закоменти
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
