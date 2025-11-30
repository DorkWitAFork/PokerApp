package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import database.GameDAO;
import model.Game;

public class GamePanel 
{

    private JFrame thisFrame;
    private JPanel thisPanel;
    private JButton startButton, endButton;
    private Game game;

    public GamePanel()
    {
        setupButtons();
        setupListen();
        setupPanel();
        setupFrame();
    }


    private void setupPanel()
    {
        thisPanel = new JPanel(new FlowLayout());
        thisPanel.add(startButton);
        thisPanel.add(endButton);
    }

    private void setupFrame()
    {
        thisFrame = new JFrame("Game Setup");
        thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisFrame.setMinimumSize(new Dimension(500, 200));
        thisFrame.setResizable(false);
        thisFrame.setVisible(true);
        thisFrame.setLocationRelativeTo(null);


    }


    private void setupButtons()
    {
        startButton = new JButton("Start a Game");
        startButton.setContentAreaFilled(false);
        startButton.setBackground(Color.GRAY);
        startButton.setPreferredSize(new Dimension(200, 30));
        startButton.setVisible(true);
        startButton.setOpaque(true);

        
        endButton = new JButton("Start a Game");
        endButton.setContentAreaFilled(false);
        endButton.setBackground(Color.GRAY);
        endButton.setPreferredSize(new Dimension(200, 30));
        endButton.setVisible(true);
        endButton.setOpaque(true);

    }

    private void setupListen()
    {

        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                startPress();
            }
            
        });

        endButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                endPress();
            }
            
        });

    }


    //Action methods
    private void endPress()
    {
        GameDAO.endGame(game);
    }

    private void startPress()
    {
        
        GameDAO.startGame(game);
    }
}
