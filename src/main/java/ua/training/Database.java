/*
 * Database
 *
 * Description: This source file is a part of the
 * web app, that provides registration form, takes input,
 * checks it for validity and records to database.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/03/22
 *
 * Updated: 2018/03/25
 */
package ua.training;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

/**
 * Database class
 * Aimed to set connection between web app and database,
 * execute queries.
 */
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * addUser method
     * Connects to database, checks user's login for uniqueness.
     * Adds a new user to database in case input data is valid.
     * @param user
     * @return true - if user has been successfully added to
     * database, otherwise - false.
     */
    boolean addUser(User user) {
        String queryIfFreeLogin = "SELECT login FROM mydb.users where login = '" + user.getLogin()+ "'";
        String queryAddUser = "INSERT INTO mydb.users (name, age, email, login, password) VALUES ('"
                + user.getName() + "', '" + user.getAge() + "', '" + user.getEmail() + "', '"
                + user.getLogin() + "', '" + user.getPassword() + "')";
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Failed to import class Driver");
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            ResultSet loginInUse = statement.executeQuery(queryIfFreeLogin);
            if (loginInUse.next()) {
                connection.close();
                return false;
            }
            statement.execute(queryAddUser);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

