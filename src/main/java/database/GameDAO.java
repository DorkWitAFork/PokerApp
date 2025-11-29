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
//        String sql = """
//                    INSERT INTO games
//                """;
//
//        // Assuming the game's start time has not been established, set it to right now.
//        if(game.getStart_time() == null) {
//            game.setStart_time(LocalDateTime.now());
//        }

        return game;
    }

    public Game endGame(Game game) {
        System.out.println("End game called!");
        // Todo: implement logic. This is called when the admin selects "End game" from the game panel.


        return game;
    }
}
