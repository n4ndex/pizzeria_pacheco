package manage.model;

import java.sql.*;
import java.util.ArrayList;

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

    /*public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public int getLatestOrderCode() {
        int latestOrderCode;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT MAX(order_code) " +
                            "FROM orders;");
            ResultSet latestOrderCodeResult = preparedStatement.executeQuery();
            latestOrderCodeResult.next();
            latestOrderCode = latestOrderCodeResult.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return latestOrderCode;
    }

    public ResultSet getDefaultPizzas() {
        ResultSet pizzas;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT pizza_code, pizza_name, prize, size " +
                            "FROM pizzas " +
                            "WHERE order_code = 0;");
            pizzas = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pizzas;
    }

    public boolean checkLogin(int client_number, String password) {
        boolean check;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * " +
                            "FROM clients " +
                            "WHERE client_number = ? AND password = ?;");
            preparedStatement.setInt(1, client_number);
            preparedStatement.setString(2, password);
            ResultSet resul = preparedStatement.executeQuery();
            check = resul.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    public boolean checkIfClientExists(int client_number) {
        boolean ifExists;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT client_number " +
                            "FROM clients " +
                            "WHERE client_number = ?;");
            preparedStatement.setInt(1, client_number);
            ResultSet resul = preparedStatement.executeQuery();
            ifExists = resul.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ifExists;
    }

    public void createOrder(int client_number) {
        insertOrder(client_number);
    }

    public void createOrderAndClient(int client_number, String password) {
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO clients (client_number, password) " +
                            "VALUES (?, ?);");
            preparedStatement.setInt(1, client_number);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            insertOrder(client_number);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertOrder(int client_number) {
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders (client_number) " +
                            "VALUES (?);");
            preparedStatement.setInt(1, client_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewPizzaToOrder(int pizzaCode, String pizzaName, double prize, String pizzaSize, int currentOrderIndex) {
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO pizzas (pizza_code, pizza_name, prize, size, order_code) " +
                            "VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, pizzaCode);
            preparedStatement.setString(2, pizzaName);
            preparedStatement.setDouble(3, prize);
            preparedStatement.setString(4, pizzaSize);
            preparedStatement.setInt(5, currentOrderIndex);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getOrderData(int order_number) {
        ResultSet orderData;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT orders.order_code, orders.order_type, orders.recieved, orders.client_number, pizzas.pizza_code, pizzas.pizza_name, pizzas.prize, pizzas.pizza_size " +
                            "FROM orders INNER JOIN pizzas ON orders.order_code = pizzas.order_code " +
                            "WHERE orders.order_code = ?;");
            preparedStatement.setInt(1, order_number);
            orderData = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderData;
    }
}
