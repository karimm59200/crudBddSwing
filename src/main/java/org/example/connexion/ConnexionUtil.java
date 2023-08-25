package org.example.connexion;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnexionUtil {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "cruddbswing";
            String url = "jdbc:mysql://localhost:3306/";
            Connection connection = java.sql.DriverManager.getConnection(url+database, "root", "test");
            return connection;
        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
            return null;
        }

    }
}
