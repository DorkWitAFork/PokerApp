package model;

import java.time.LocalDateTime;
import java.util.List;

public class Game {
    private int gameMoneyIn; // in cents
    private int gameMoneyOut; // in cents
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private int id;
    private boolean closed;
    private List<GameParticipant> game_participants;

    // Empty constructor for the DAO to work with.
    // This is the main one we will work with. Creating a new game will call this constructor.
    // The DAO will fill this with data upon creation, such as id, start time, and moneyIn.
    // Once the game is over and endGame() is called from the DAO, closed will be set to true.
    // It will also update the end_time and gameMoneyOut.
    // For the sake of the MVP, we will not allow the admin to add users to a game once it has been started.
    // This means that for now, the only time the list of game participants is updated is on the initial creation screen.
    // This means the DAO is passed the list of game participants from the start and will write that to the game participant table.
    public Game() {
        this.closed = false;
    }

    // Temporary constructor that will be used for some testing.
    public Game(List<GameParticipant> participants) {
        this.game_participants = participants;
        this.closed = false;
    }

    // This is a fully filled constructor to be used when reading from the DB.
    public Game(int gameMoneyIn, int gameMoneyOut, LocalDateTime start_time,
                LocalDateTime end_time, int id, boolean closed, List<GameParticipant> game_participants) {
        this.gameMoneyIn = gameMoneyIn;
        this.gameMoneyOut = gameMoneyOut;
        this.start_time = start_time;
        this.end_time = end_time;
        this.id = id;
        this.closed = closed;
        this.game_participants = game_participants;
    }

    // This will be a new game constructor where the DB will assign some other attributes.
    // Note: might not use this one honestly. Keeping it for now.
    public Game(int gameMoneyIn, LocalDateTime start_time) {
        this.gameMoneyIn = gameMoneyIn;
        this.start_time = start_time;
        this.closed = false;
    }

    public void setGameMoneyIn(int gameMoneyIn) {
        this.gameMoneyIn = gameMoneyIn;
    }

    public int getGameMoneyIn() {
        return gameMoneyIn;
    }

    public void setGameMoneyOut(int gameMoneyOut) {
        this.gameMoneyOut = gameMoneyOut;
    }

    public int getGameMoneyOut() {
        return gameMoneyOut;
    }

    public void setStartTime(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getStartTime() {
        return start_time;
    }

    public void setEndTime(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public LocalDateTime getEndTime() {
        return end_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean getClosed() {
        return closed;
    }

    public void setGameParticipants(List<GameParticipant> game_participants) {
        this.game_participants = game_participants;
    }

    public List<GameParticipant> getGameParticipants() {
        return game_participants;
    }

    @Override
    public String toString() {
        return "Game{id=" + id +
                "moneyIn=" + gameMoneyIn / 100 +
                "moneyOut=" + gameMoneyOut / 100 +
                "startTime=" + start_time +
                "endTime=" + end_time +
                "gameParticipants=" + game_participants
                + "+}";
    }

}
