package test;

import database.*;
import model.*;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class databaseGameTEST {

    private static Connection connection;
    private static GameDAO gameDAO;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        // Create an in-memory database (temporary; deleted when connection closes)
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");

        // Create only the tables we need for GameDAO tests
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                CREATE TABLE games (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    start_time TEXT NOT NULL,
                    end_time TEXT,
                    game_money_in INTEGER NOT NULL,
                    game_money_out INTEGER NOT NULL,
                    closed INTEGER DEFAULT 0
                );
            """);

            statement.execute("""
                CREATE TABLE player_game_keys (
                    game_id INTEGER NOT NULL,
                    player_id INTEGER NOT NULL,
                    FOREIGN KEY (game_id) REFERENCES games(id)
                );
            """);
        }

        gameDAO = new GameDAO(connection);
        System.out.println("In-memory test database setup complete.");
    }

    @Test
    public void testStartGame() {
        Game game = new Game();
        game.setStartTime(LocalDateTime.now());

        GameParticipant participant = new GameParticipant(1, 100);

        List<GameParticipant> participants = new ArrayList<>();
        participants.add(participant);
        game.setGameParticipants(participants);

        // Act
        gameDAO.startGame(game);

        // Assert
        assertTrue(game.getId() > 0, "Game ID should be assigned after starting the game");
        System.out.println("Game started successfully with ID: " + game.getId());
    }

    @Test
    public void testEndGame() {
        Game game = new Game();
        game.setId(1); // pretend it's existing
        game.setStartTime(LocalDateTime.now());
        game.setEndTime(LocalDateTime.now().plusHours(1));
        game.setGameMoneyIn(100);
        game.setGameMoneyOut(100);
        game.setClosed(false);

        gameDAO.endGame(game);

        assertTrue(game.getClosed(), "Game should be marked as closed");
        System.out.println("Game ended successfully.");
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        connection.close();
        System.out.println("In-memory database closed.");
    }
}