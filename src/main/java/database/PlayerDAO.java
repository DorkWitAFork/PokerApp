package database;
import model.Player;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// This class will handle all operations concerning the database operations
// for the Player.

// DB Schema
/*
        id INTEGER PRIMARY KEY AUTOINCREMENT
        name TEXT NOT NULL
        created_at TEXT NOT NULL
 */
public class PlayerDAO {
    private Connection connection;

    // CONSTRUCTOR
    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }

    // INSERT NEW PLAYER INTO DATABASE
    public Player addPlayer(Player player) throws SQLException {
        String sql = """
                INSERT INTO players (name, created_at)
                VALUES (?, ?)
                """;
        // The creation time is going to be the time of adding them.
        if (player.getCreation() == null) {
            player.setCreation(LocalDateTime.now());
        }

        try (PreparedStatement statement =
                connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, player.getName());
            statement.setString(2, player.getCreation().toString());

            int rows = statement.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Inserting player failed, no rows were updated.");
            }

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    player.setID(keys.getInt(1));
                } else {
                    throw new SQLException("Inserting player failed, no ID obtained.");
                }
            }
        }
        return player;
    }
}
