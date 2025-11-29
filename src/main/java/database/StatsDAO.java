package database;

import model.PlayerStats;

public class StatsDAO {

    public PlayerStats getPlayerStats(int playerId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // The parameter here, limit, represents how many players it will query.
    // This means you good pass five to get the top 5, or 10 to get the top 10, etc.
    public PlayerStats getLeaderboardByProfit(int limit) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
