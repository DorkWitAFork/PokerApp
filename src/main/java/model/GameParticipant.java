package model;

public class GameParticipant {

    private int id; // This is the primary key in the DB
    private int gameId; // This is the foreign key to the associated game id.
    private int playerId; // This is the foreign key to the associated player id.

    private int moneyIn; // In cents
    private int moneyOut; // In cents

    // Constructor to fully populate a GameParticipant object when reading from the DB
    public GameParticipant(int id, int gameId, int playerId,
                           int moneyIn, int moneyOut) {
        this.id = id;
        this.gameId = gameId;
        this.playerId = playerId;
        this.moneyIn = moneyIn;
        this.moneyOut = moneyOut;
    }

    // Constructor to be used when adding a participant to an existing game in the DB, meaning we have the game id.
    public GameParticipant(int gameId, int playerId, int moneyIn, int moneyOut) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.moneyIn = moneyIn;
        this.moneyOut = moneyOut;
    }

    // Constructor to be used when the game is still being created and does not have a game id assigned yet.
    public GameParticipant(int playerId, int moneyIn) {
        this.playerId = playerId;
        this.moneyIn = moneyIn;
    }

    public void setMoneyIn(int moneyIn) {
        this.moneyIn = moneyIn;
    }

    public int getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyOut(int moneyOut) {
        this.moneyOut = moneyOut;
    }

    public int getMoneyOut() {
        return moneyOut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        return "Participant{id=" + id +
                ", gameId=" + gameId +
                ", playerId=" + playerId +
                ", moneyIn=" + moneyIn +
                "}";
    }
}
