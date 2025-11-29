package database;
import model.Game;
import model.GameParticipant;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class GameParticipantDAO {

    private final Connection connection;

    public GameParticipantDAO(Connection connection) {
        this.connection = connection;
    }

    public GameParticipant addParticipant(int gameId, int playerId, int buyIn) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void updateCashOut(int participantId, int cashOut) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<GameParticipant> getParticipantsByGame(int gameId) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<GameParticipant> getParticipantsByPlayer(int playerId) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }



}
