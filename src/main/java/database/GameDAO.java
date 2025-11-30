package database;
import model.Game;
import model.GameParticipant;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

// This class's responsibility is handling the DB interactions concerning Game objects.

// Database Schema
/*
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    start_time TEXT NOT NULL,
                    end_time TEXT,
                    game_money_in INTEGER NOT NULL,
                    game_money_out INTEGER NOT NULL,
                    closed INTEGER DEFAULT 0);

                    player_game_keys Schema

                    CREATE TABLE IF NOT EXISTS player_game_keys(
                    game_id INTEGER NOT NULL,
                    player_id INTEGER NOT NULL,
                    FOREIGN KEY (game_id) REFERENCES games(id),
                    FOREIGN KEY (player_id) REFERENCES players(id));
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
        if(game.getStartTime() == null) {
            game.setStartTime(LocalDateTime.now());
        }

        try(PreparedStatement statement =
                connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, game.getStartTime().toString());
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

            String add_players = """
                    INSERT INTO game_player_keys (game_id, player_id)
                    VALUES (?,?)
                    """;

            PreparedStatement addPlayersStatement = connection.prepareStatement(add_players);
            List<GameParticipant> participants = game.getGameParticipants();
            if (participants != null) {
                for (GameParticipant participant : participants) {
                    addPlayersStatement.setInt(1, game.getId());
                    addPlayersStatement.setInt(2, participant.getPlayerId());
                    addPlayersStatement.addBatch();;
                }
                addPlayersStatement.executeBatch();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    public Game endGame(Game game) {
        System.out.println("End game called!");
        // endGame should write the end_time, total money out (calculated from adding up player totals), and
        // update closed to true

        // Set end time to now, the time at which endGame() is called.
        if(game.getEndTime() == null) {
            game.setEndTime(LocalDateTime.now());
        }

        List<GameParticipant> participants = game.getGameParticipants();

        // Total up the game money out from each participant's total money out.
        if (participants != null) {
            for (GameParticipant participant : participants) {
                game.setGameMoneyOut(game.getGameMoneyOut() + participant.getMoneyOut());
            }
        }

        // Mark the game as closed.
        game.setClosed(true);

        String sql = """
                INSERT INTO TABLE games(end_time, game_money_out, closed)
                VALUES (?,?,?)
                """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, game.getEndTime().toString());
            statement.setInt(2, game.getGameMoneyOut());
            statement.setBoolean(3, game.getClosed());

            int rows = statement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Error occurred, could not update end game details.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return game;
    }
}
