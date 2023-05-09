package manage.model;

import java.sql.Driver;
import java.sql.SQLException;

public class MainConnectionModel {
    private final Driver DRIVER;
    private final String URL;
    private String DATABASE;
    private final String USERNAME;
    private final String PASSWORD;


    public MainConnectionModel() {
        try {
            DRIVER = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        URL = "jdbc:mysql://localhost/";
        DATABASE = "pizzeria_pacheco";
        USERNAME = "root";
        PASSWORD = "";
    }

    public Driver getDRIVER() {
        return DRIVER;
    }

    public String getURL() {
        return URL;
    }

    public String getDATABASE() {
        return DATABASE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
