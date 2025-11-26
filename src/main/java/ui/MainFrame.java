package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setupListen();
        
    }

    private void setupFrame()
    {
        //Frame layout will be flow by default
        mainFrame = new JFrame("Welcome to Poker Tracker!");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(500, 200));
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
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
        //Create the buttons and their looks
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

        leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setContentAreaFilled(false);
        leaderboardButton.setBackground(Color.GRAY);
        leaderboardButton.setPreferredSize(new Dimension(200, 30));
        leaderboardButton.setVisible(true);
        leaderboardButton.setOpaque(true);

        createButton = new JButton("Player Creation");
        createButton.setContentAreaFilled(false);
        createButton.setBackground(Color.GRAY);
        createButton.setPreferredSize(new Dimension(200, 30));
        createButton.setVisible(true);
        createButton.setOpaque(true);

        
    }

    //The method that makes the buttons actually DO something
    private void setupListen()
    {
        newGameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                newGamePress();
            }
        });

        playerLookupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                playerLookupPress();
            }
        });

        reportButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                reportPress();
            }
        });

        leaderboardButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                leaderboardPress();
            }
        });

        createButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                createPress();
            }
        });
    }

    //What the buttons do when they are clicked
    private void newGamePress()
    {
        System.out.println("New Game Press");
    }

    private void playerLookupPress()
    {
        System.out.println("Lookup Press");
    }

    private void reportPress()
    {
        System.out.println("Report Press");
    }

    private void leaderboardPress()
    {
        System.out.println("Leaderboard Press");
    }

    private void createPress()
    {
        System.out.println("Create Press");
    }



}
