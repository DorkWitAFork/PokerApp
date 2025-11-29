package model;

// This is more of a read only class. It will create objects to get stats for player totals.

public class PlayerStats {

    private final int playerId;
    private final String name;
    private final int gamesPlayed;
    private final int totalMoneyIn;
    private final int totalMoneyOut;
    private final int netProfit;

    public PlayerStats(int playerId, String name, int gamesPlayed,
                       int totalMoneyIn, int totalMoneyOut, int netProfit) {
        this.playerId = playerId;
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.totalMoneyIn = totalMoneyIn;
        this.totalMoneyOut = totalMoneyOut;
        this.netProfit = netProfit;
    }

    // Getter functions

    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getTotalMoneyIn() {
        return totalMoneyIn;
    }

    public int getTotalMoneyOut() {
        return totalMoneyOut;
    }

    public int getNetProfit() {
        return netProfit;
    }
}
