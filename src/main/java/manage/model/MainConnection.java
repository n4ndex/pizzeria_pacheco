package manage.model;

import java.sql.*;
import java.util.*;

public class MainConnection {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ArrayList<ResultSet> resultSets;

    public MainConnection(String URL, String USERNAME, String PASSWORD, Driver DRIVER) {
        try {
            DriverManager.registerDriver(DRIVER);
            openConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openConnection(String URL, String USERNAME, String PASSWORD) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
