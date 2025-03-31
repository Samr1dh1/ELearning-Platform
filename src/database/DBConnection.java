package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/elearning";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    // Private constructor to prevent instantiation
    private DBConnection() {}

    // Method to establish connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to connect to the database.");
            }
        }
        return connection;
    }

    // Method to close connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error closing the database connection.");
            }
        }
    }
}
