package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:sqlite:data/poker.db";

    // One connection for the whole app
    public static Connection getConnection() throws SQLException {
        System.out.println("Connected to the DB");
        return DriverManager.getConnection(URL);
    }
}
