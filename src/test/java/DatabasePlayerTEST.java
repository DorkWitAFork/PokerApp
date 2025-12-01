package test;

import database.*;
import model.Player;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DatabasePlayerTEST {

    private static Connection connection;
    private static PlayerDAO playerDAO;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        // In-memory SQLite database
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");

        // Create table for players
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                CREATE TABLE players (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    created_at TEXT
                );
            """);
        }

        playerDAO = new PlayerDAO(connection);
        System.out.println("Player test database setup complete.");
    }

    @Test
    public void testAddPlayer() throws SQLException {
        Player player = new Player();
        player.setName("Alice");

        // Insert into the database
        playerDAO.addPlayer(player);

        // Query the database directly to confirm
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM players WHERE name = 'Alice'");

        assertTrue(rs.next(), "Player should be found in the database after insertion");
        assertEquals("Alice", rs.getString("name"), "Player name should match input");

        System.out.println("Player added successfully: " + rs.getString("name"));
        rs.close();
        stmt.close();
    }

    @Test
    public void testAddMultiplePlayers() throws SQLException {
        Player p1 = new Player();
        p1.setName("Bob");

        Player p2 = new Player();
        p2.setName("Charlie");

        playerDAO.addPlayer(p1);
        playerDAO.addPlayer(p2);

        // Query both players directly from the database
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM players ORDER BY id");

        List<String> playerNames = new ArrayList<>();
        while (rs.next()) {
            playerNames.add(rs.getString("name"));
        }

        assertTrue(playerNames.contains("Bob") && playerNames.contains("Charlie"),
                "Both players should be found in the database");
        System.out.println("Multiple players inserted successfully: " + playerNames);

        rs.close();
        stmt.close();
    }

    @Test
    public void testPlayerInsertionFailsWhenNameIsNull() {
        Player player = new Player();
        player.setName(null); // should fail

        assertThrows(SQLException.class, () -> playerDAO.addPlayer(player),
                "Adding a player with null name should throw an SQLException");
        System.out.println("Null name insertion correctly failed.");
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        connection.close();
        System.out.println("Test database connection closed.");
    }
}
