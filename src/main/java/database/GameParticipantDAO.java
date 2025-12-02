package database;
import model.Game;
import model.GameParticipant;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


/*
                    CREATE TABLE IF NOT EXISTS  game_participants(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    game_id INTEGER NOT NULL,
                    player_id INTEGER NOT NULL,
                    buy_in INTEGER NOT NULL,
                    cash_out INTEGER NOT NULL DEFAULT 0,
                    FOREIGN KEY (game_id) REFERENCES games(id),
                    FOREIGN KEY (player_id) REFERENCES players(id));

 */

public class GameParticipantDAO {

    static final Connection connection = DatabaseManager.getInstance().getConnection();

    public GameParticipantDAO(Connection connection) {
    }

    public void insert(GameParticipant participant) {
        // Todo: implement logic to add a player to a game.
        // This would be called when a player and their initial buy-in is entered for a game session.
        // INSERT INTO game_participants
    }

    /**
     *
     * @param gameId The int representation of a game
     * @return A linked list of GameParticipants
     * @throws SQLException is thrown when either the query fails
     */
    public List<GameParticipant> findByGameId(int gameId) throws SQLException {
        List<GameParticipant> results;
        PreparedStatement smt = connection.prepareStatement(
                """
                SELECT * FROM game_participants where game_id = ?"""
        );
        smt.setInt(1, gameId);

        ResultSet query_values = smt.executeQuery();
        results = new LinkedList<>();
        if (!isResultSetEmpty(query_values)) {
            while (query_values.next()) {
                //TODO: Do you want the possibility of null values populating this list?
                results.add(mapRowToObj(query_values));
            }
        }

        return results;
    }

    public GameParticipant findByGameAndPlayer(int gameId, int playerId) {
        // Might not be strictly necessary. Could be useful when updating one player's cash-out.
        // SELECT * FROM game_participants WHERE game_id = ? AND player_id = ?
        return null;
    }

    public void updateCashOut(int gameId, int playerId, int cashOut) {
        // Todo: Implement function to update a player's cash-out at the conclusion of a game.
        // UPDATE game_participants SET cash_out = ? WHERE game_id = ? AND player_id = ?
    }

    // Optional, at least for Sprint 1.
    public void updateBuyIn(int gameId, int playerId, int newBuyIn) {
        // Could be used for re-buys or add-ons
        // UPDATE game_participants SET cash_in = ? WHERE game_id = ? AND player_id = ?
    }

    // Helper functions for GameDAO. just a clean way to total up the sums of everyone's buy-ins and cash-outs.

    public int getTotalBuyInForGame(int gameId) {
        // Todo: implement function to total the buy in for a game.
        // SELECT SUM (buy_in) FROM game_participants WHERE game_id = ?
        return 0;
    }

    public int getTotalCashOutGame(int gameId) {
        // Todo: implement function to total the cash-out for a game.
        // This was partially implemented in the GameDAO function endGame().
        // SELECT SUM(cash_out) FROM game_participants WHERE game_id = ?
        return 0;
    }


    // The following might be for Sprint 2, like Leaderboard stuff.
    public List<GameParticipant> findGamesByPlayerId(int playerId) {
        // This can be good to get all games a player has ever played
        // SELECT * FROM game_participants WHERE player_id = ?
        return null;
    }

    private boolean isResultSetEmpty(ResultSet rs) {
        boolean result = true;
        int count = 0;
        try {
            if (rs.last()) {
                count = rs.getRow();
                rs.beforeFirst();
            }
        } catch (SQLException e) {
            return result;
        }
        if (count > 0) {
            result = false;
        }
        return result;
    }

    private GameParticipant mapRowToObj(ResultSet rs) {
        GameParticipant gp = null;
        try {
            int id = rs.getInt("id");
            int gameId = rs.getInt("game_id");
            int playerId = rs.getInt("player_id");
            int moneyIn = rs.getInt("buy_in");
            int moneyOut = rs.getInt("cash_out");

            gp = new GameParticipant(id, gameId, playerId, moneyIn, moneyOut);
        } catch (SQLException e) {
            return gp;
        }

        return gp;
    }
}

