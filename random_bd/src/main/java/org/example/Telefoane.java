package org.example;

import org.h2.tools.Server;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Telefoane {

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        try {
            Server webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
            System.out.println("H2 Console started at: http://localhost:8082");

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected to H2 in-memory database.\n");

                createTable(connection);

                insertTelefon(connection, "A6+", 2018, 32);
                insertTelefon(connection, "A13", 2022, 64);
                insertTelefon(connection, "Jerry 2", 2017, 8);
                insertTelefon(connection, "J3", 2017, 16);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE Telefoane (
                    denumire VARCHAR(100) PRIMARY KEY,
                    an INT,
                    stocare INT
                )
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table 'telefoane' created.");
        }
    }

    private static void insertTelefon(Connection connection, String denumire, int an, int stocare) throws SQLException {
        String sql = "INSERT INTO Telefoane (denumire, an, stocare) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, denumire);
            ps.setInt(2, an);
            ps.setInt(3, stocare);

            ps.executeUpdate();
            System.out.println("Inserted: " + denumire);
        }
    }

}