package g.example;

import java.sql.*;

import org.h2.tools.Server;

public class film {
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

                insertFilm(connection, "Love & other drugs",2010, "engleza");
                insertFilm(connection, "The Impossible",2012, "engleza");
                insertFilm(connection, "Funny Games",2007, "engleza");
                insertFilm(connection, "Transporter 2",2005, "engleza");

                System.out.println("=== ALL STUDENTS AFTER INSERT ===");
                printAllFilme(connection);

                updateFilmLimba(connection, "Parasite", "italiana");
                System.out.println("\n=== ALL STUDENTS AFTER UPDATE ===");
                printAllFilme(connection);

                deleteFilm(connection, 2005);
                System.out.println("\n=== ALL STUDENTS AFTER DELETE ===");
                printAllFilme(connection);

                System.out.println("\nOpen the H2 console in your browser!");
                System.out.println("JDBC URL: " + URL);
                System.out.println("User: sa (no password)");
                System.out.println("\nPress ENTER to exit...");
                System.in.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void createTable(Connection connection) throws SQLException {
        String sql = """
            CREATE TABLE Filme (
                denumire VARCHAR(100) PRIMARY KEY,
                an INT,
                limba VARCHAR(100) NOT NULL
            )
            """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table 'filme' created.");
        }
    }

    private static void insertFilm(Connection connection, String denumire, int an, String limba) throws SQLException {
        String sql = "INSERT INTO filme (denumire, an, limba) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, denumire);
            ps.setInt(2, an);
            ps.setString(3, limba);

            ps.executeUpdate();
            System.out.println("Inserted: " + denumire);
        }
    }

    private static void printAllFilme(Connection connection) throws SQLException {
        String sql = "SELECT denumire,an,limba FROM filme ORDER BY an";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("denumire") + " | " +
                                rs.getInt("an") + " | " +
                                rs.getString("limba")
                );
            }
        }
    }

    private static void updateFilmLimba(Connection connection, String denumire, String newLimba) throws SQLException {
        String sql = "UPDATE filme SET limba = ? WHERE denumire = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newLimba);
            ps.setString(2, denumire);

            ps.executeUpdate();
            System.out.println("Updated limba filmului " + denumire);
        }
    }

    private static void deleteFilm(Connection connection, int an) throws SQLException {
        String sql = "DELETE FROM filme WHERE an = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, an);

            ps.executeUpdate();
            System.out.println("Deleted fimul din anul " + an);
        }
    }
}
