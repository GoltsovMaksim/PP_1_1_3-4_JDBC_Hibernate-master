package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Nik", "Reed", (byte) 20);
        userDao.saveUser("Mike", "Boom", (byte) 25);
        userDao.saveUser("Black", "Rock", (byte) 31);
        userDao.saveUser("Kid", "Maple", (byte) 38);

        userDao.removeUserById(1);
        System.out.println(userDao.getAllUsers().get(0));
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
