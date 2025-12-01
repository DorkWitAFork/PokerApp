package org.example;

import model.Player;
import model.Game;
import model.GameParticipant;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import ui.MainFrame;

import database.Database;
import database.PlayerDAO;
import database.CreateTable;
import database.GameDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Attempting to create DB tables");
        CreateTable.initialize();

        // Try testing the player class. Establish connection to the database.
        try (Connection connection = Database.getConnection()) {

            // Create a new playerDAO and pass it the DB connection.
            PlayerDAO playerDAO = new PlayerDAO(connection);

            // Create a new player
            Player player1 = new Player("Spencer");
            Player player2 = new Player("Alex");
            Player player3 = new Player("Nate");

            // Add the player
            playerDAO.addPlayer(player1);
            playerDAO.addPlayer(player2);
            playerDAO.addPlayer(player3);

            System.out.println("Player inserted: " + player1);
            System.out.println("Player inserted: " + player2);
            System.out.println("Player inserted: " + player3);

            GameDAO gameDAO = new GameDAO(connection);

            List<GameParticipant> participants = new ArrayList<GameParticipant>();
            GameParticipant part1 = new GameParticipant(3, 5000);
            GameParticipant part2 = new GameParticipant(4, 5000);
            GameParticipant part3 = new GameParticipant(5, 5000);
            participants.add(part1);
            participants.add(part2);
            participants.add(part3);

            System.out.println("GP inserted: " + part1);
            System.out.println("GP inserted: " + part2);
            System.out.println("GP inserted: " + part3);

            Game game = new Game(participants);
            gameDAO.startGame(game);
            gameDAO.endGame(game);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Attempting to create a main frame");
        new MainFrame();
    }
}
