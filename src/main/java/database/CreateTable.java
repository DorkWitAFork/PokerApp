package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void initialize() {
        try (Connection connection = Database.getConnection()) {
            Statement statement = connection.createStatement();

            // Create the players table
            statement.execute("""
                CREATE TABLE IF NOT EXISTS players (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    created_at TEXT NOT NULL);
                """
            );
            System.out.println("player table creation worked.");

            statement.execute("""
                CREATE TABLE IF NOT EXISTS games (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    start_time TEXT NOT NULL,
                    end_time TEXT,
                    closed INTEGER DEFAULT 0);
                """
            );
            System.out.println("games table creation worked.");

            statement.execute("""
                CREATE TABLE IF NOT EXISTS  game_participants(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    game_id INTEGER NOT NULL,
                    player_id INTEGER NOT NULL,
                    buy_in INTEGER NOT NULL,
                    cash_out INTEGER NOT NULL DEFAULT 0,
                    FOREIGN KEY (game_id) REFERENCES games(id),
                    FOREIGN KEY (player_id) REFERENCES players(id));
                """
            );
            System.out.println("game_participants table creation worked.");

            System.out.println("If you're seeing this, all tables created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
