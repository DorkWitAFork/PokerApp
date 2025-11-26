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
    public Game(int gameMoneyIn, int gameMoneyOut, LocalDateTime start_time) {
        this.gameMoneyIn = gameMoneyIn;
        this.gameMoneyOut = gameMoneyOut;
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

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean getClosed() {
        return closed;
    }

    public void setGame_participants(List<GameParticipant> game_participants) {
        this.game_participants = game_participants;
    }

    public List<GameParticipant> getGame_participants() {
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
