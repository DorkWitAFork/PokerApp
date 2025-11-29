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


}
