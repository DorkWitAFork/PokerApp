package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:sqlite:data/poker.db";
    private static Connection connection = null;

    // One connection for the whole app
    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL);
        System.out.println("Connected to the DB");
        return connection;
//        if (connection == null) {
//            try {
//                connection = DriverManager.getConnection(URL);
//                System.out.println("Connected to the SQLite Database");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return connection;
    }
}
