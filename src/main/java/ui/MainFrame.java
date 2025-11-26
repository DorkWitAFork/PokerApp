package ui;
import javax.swing.*;
import java.awt.*;

public class MainFrame 
{
    private JFrame mainFrame;
    private JButton newGameButton, playerLookupButton, reportButton, leaderboardButton, createButton;
    private JPanel mainPanel;


    public MainFrame()
    {
        mainPanel = new JPanel();
        setupButtons();
        setupFrame();
        
    }

    private void setupFrame()
    {
        //Frame layout will be flow by default
        mainFrame = new JFrame("Welcome to Poker Tracker!");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(500, 200));
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

        //Add the panel to hold the buttons
        mainFrame.add(mainPanel);

        //Adding buttons to the panel, not the frame
        mainPanel.add(newGameButton);
        mainPanel.add(playerLookupButton);
        mainPanel.add(reportButton);
        mainPanel.add(leaderboardButton);
        mainPanel.add(createButton);

        

    }

    private void setupButtons()
    {
        newGameButton = new JButton("Create New Game");
        newGameButton.setContentAreaFilled(false);
        newGameButton.setBackground(Color.GRAY);
        newGameButton.setPreferredSize(new Dimension(200, 30));
        newGameButton.setVisible(true);
        newGameButton.setOpaque(true);

        playerLookupButton = new JButton("Player Lookup");
        playerLookupButton.setContentAreaFilled(false);
        playerLookupButton.setBackground(Color.GRAY);
        playerLookupButton.setPreferredSize(new Dimension(200, 30));
        playerLookupButton.setVisible(true);
        playerLookupButton.setOpaque(true);

        reportButton = new JButton("Make Report");
        reportButton.setContentAreaFilled(false);
        reportButton.setBackground(Color.GRAY);
        reportButton.setPreferredSize(new Dimension(200, 30));
        reportButton.setVisible(true);
        reportButton.setOpaque(true);

        leaderboardButton = new JButton("Player Lookup");
        leaderboardButton.setContentAreaFilled(false);
        leaderboardButton.setBackground(Color.GRAY);
        leaderboardButton.setPreferredSize(new Dimension(200, 30));
        leaderboardButton.setVisible(true);
        leaderboardButton.setOpaque(true);

        createButton = new JButton("Player Lookup");
        createButton.setContentAreaFilled(false);
        createButton.setBackground(Color.GRAY);
        createButton.setPreferredSize(new Dimension(200, 30));
        createButton.setVisible(true);
        createButton.setOpaque(true);

        
    }
}
