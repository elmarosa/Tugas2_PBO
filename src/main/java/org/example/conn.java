package org.example;
import java.sql.DriverManager;
import java.sql.*;

public class conn {
    private Connection connection;

    public conn() {
        try {
            this.connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:dbElma.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
