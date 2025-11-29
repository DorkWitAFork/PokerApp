package database;
import model.Game;

import java.sql.*;
import java.time.LocalDateTime;

// This class's responsibility is handling the DB interactions concerning Game objects.

// Database Schema
/*
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    start_time TEXT NOT NULL,
                    end_time TEXT,
                    game_money_in INTEGER NOT NULL,
                    game_money_out INTEGER NOT NULL,
                    closed INTEGER DEFAULT 0);
*/


public class GameDAO {

    private final Connection connection;

    public GameDAO(Connection connection) {
        this.connection = connection;
    }

    public Game startGame(Game game) {
        System.out.println("Start game called!");

        // Todo: implement logic. Should add to the passed game object the start time, participants, money in, and (maybe) id.
        String sql = """
                    INSERT INTO games (start_time, game_money_in)
                    VALUES (?,?)
                """;

        // Assuming the game's start time has not been established, set it to right now.
        if(game.getStart_time() == null) {
            game.setStart_time(LocalDateTime.now());
        }

        try(PreparedStatement statement =
                connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, game.getStart_time().toString());
            statement.setInt(2, game.getGameMoneyIn());

            // Update the DB Rows
            int rows = statement.executeUpdate();

            // Check that it worked
            if (rows == 0) {
                throw new SQLException("Error occurred, rows not updated and game not added.");
            }

            // Now try to get the generated ID for the game_id
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    game.setId(keys.getInt(1));
                } else {
                    throw new SQLException("Error, insertion failed. No key generated.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    public Game endGame(Game game) {
        System.out.println("End game called!");
        // Todo: implement logic. This is called when the admin selects "End game" from the game panel.


        return game;
    }
}
