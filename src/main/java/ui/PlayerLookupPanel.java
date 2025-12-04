package ui;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerLookupPanel 
{

    //result panel will hold the detailed results in a more contained area, makes it look a bit cleaner
    //mid panel holds the search results
    //top panel is search area
    //bottom panel holds page numbers, just in case
    private JPanel midPanel, topPanel, bottomPanel, rightPanel, resultPanel;
    private JFrame thisFrame;
    private JTextField searchbar;
    private JButton searchButton;

    public PlayerLookupPanel()
    {
        setupElements();
        setupListen();
        setupPanels();
        setupFrame();
    }

    private void setupFrame()
    {
        thisFrame = new JFrame("Player Lookup");
        thisFrame.setLayout(new BorderLayout());
        thisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisFrame.setMinimumSize(new Dimension(500, 500));
        thisFrame.setResizable(false);
        thisFrame.setVisible(true);
        thisFrame.setLocationRelativeTo(null);


        //add some stuff
        thisFrame.add(topPanel, BorderLayout.NORTH);
        thisFrame.add(midPanel, BorderLayout.CENTER);


    }

    private void setupPanels()
    {
        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
		topPanel.setPreferredSize(new Dimension(0, 50));
		topPanel.setVisible(true);

        bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 45, 0));
		bottomPanel.setVisible(true);
		bottomPanel.setPreferredSize(new Dimension(0, 20));

        midPanel = new JPanel();
        midPanel.setBackground(Color.GRAY);
		midPanel.setLayout(null);
		midPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		midPanel.setVisible(true);
    }

    private void setupElements()
    {

    }

    private void setupListen()
    {

    }



}
