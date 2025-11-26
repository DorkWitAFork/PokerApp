package org.example;

import model.Player;

import java.sql.Connection;
import java.sql.SQLException;

import ui.MainFrame;

import database.Database;
import database.PlayerDAO;
import database.CreateTable;


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
            Player player = new Player("Spencer");

            // Add the player
            playerDAO.addPlayer(player);

            System.out.println("Player inserted: " + player);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Attempting to create a main frame");
        new MainFrame();
    }
}
