package service;

import database.PlayerDAO;
import database.GameDAO;
import database.GameParticipantDAO;
import database.DatabaseManager;

import model.Player;
import model.Game;
import model.GameParticipant;

import java.sql.Connection;
import java.util.List;

public class PokerService {

    private static PokerService instance;

    private final PlayerDAO playerDAO;
    private final GameDAO gameDAO;
    private final GameParticipantDAO gameParticipantDAO;

    private PokerService() {
        Connection connection = DatabaseManager.getInstance().getConnection();
        this.playerDAO = new PlayerDAO(connection);
        this.gameDAO = new GameDAO(connection);
        this.gameParticipantDAO = new GameParticipantDAO(connection);
    }

    public static synchronized PokerService getInstance() {
        if (instance == null) {
            instance = new PokerService();
        }
        return instance;
    }

    // ============== PLAYER OPERATIONS ===============

    // Create a new player Record. called when create a player is selected in the UI.
    public Player createPlayer(String name) {
        // Todo: build the player object, call PlayerDAO to insert, and return the player.
        return null;
    }

    // List all players. Used for search screens and dropdown menus.
    public List<Player> getAllPlayers() {
        // Todo: return the playerDAO.findAll() function. need to implement that
        return null;
    }

    // Search for players by name or partial name.
    public List<Player> searchPlayersByName(String name) {
        // Todo: use the playerDAO.searchByName(fragment);
        return null;
    }

    // Find player by ID
    public Player getPlayerById(int playerId) {
        // Todo: this will be the playerDAO.findById(id);
        return null;
    }

    // ============== GAME OPERATIONS ===============

    // Start a new game
    public Game startNewGame(int moneyIn) {
        // Todo: create game object with money in, start time, money out is 0, game participants.
        // should call gameDAO.startGame(game). return the GAme with the assigned id.
        return null;
    }

    // Return open games
    public List<Game> getOpenGames() {
        // Todo: return gameDAO.getOpenGames(); basically just a SQL query to the games table where closed is 0.
        return null;
    }

    // Get a single game with its participants loaded.
    public Game getGameDetails(int gameId) {
        // Todo: get game with participants from gameDAO functions
        return null;
    }

    // Close the game. called when admin selects end game from UI.
    public void closeGame(int gameId) {
        // Todo: accumulate the total out with gpDAO's get cash out for game.
        // call close game from gameDAO.
    }

    // ============== GAME OPERATIONS ===============

    // Add a player to the game with a buy-in amount.
    public void addParticipantToGame(int gameId, int playerId, int buyIn) {
        // Todo: build the GP object, use gpDAO.insert() to add them to the game, and update buy-in if needed.
    }

    // Update the participant's cash out for a game.
    public void updateParticipantCashOut(int gameId, int playerId, int cashOut) {
        // Todo: call the gpDAO updateCashout method.
    }

    // List the participants of a game.
    public List<GameParticipant> getParticipantsForGame(int gameId) {
        // Todo: use the gpDAO method findByGameId
        return null;
    }

    // get the total buy in for the game
    public int getTotalBuyInForGame(int gameId) {
        // Todo: use the gpDAO method getTotalBuyIn
        return 0;
    }

    // get the total buy in for the game
    public int getTotalCashOutGame(int gameId) {
        // Todo: use the gpDAO method getTotalCashOut
        return 0;
    }

    // calculate the profit or net loss
    public int getPlayerCashResult(int playerId) {
        // Todo: probably use a gpDAO netResult method
        return 0;
    }

}
