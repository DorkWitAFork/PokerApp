package ui;
import javax.swing.*;
import javax.swing.border.Border;

import model.Player;
import service.PokerService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private PokerService ps;

    public PlayerLookupPanel()
    {
        ps = PokerService.getInstance();
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
        thisFrame.add(bottomPanel, BorderLayout.SOUTH);
        thisFrame.add(rightPanel, BorderLayout.EAST);


    }

    private void setupPanels()
    {
        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
		topPanel.setPreferredSize(new Dimension(0, 50));
		topPanel.setVisible(true);
        topPanel.add(searchbar);
        topPanel.add(searchButton);

        bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 45, 0));
		bottomPanel.setVisible(true);
		bottomPanel.setPreferredSize(new Dimension(0, 20));
        bottomPanel.setBackground(Color.BLACK);

        midPanel = new JPanel();
        midPanel.setBackground(Color.LIGHT_GRAY);
		midPanel.setLayout(null);
		midPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		midPanel.setVisible(true);

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.GRAY);
		rightPanel.setLayout(null);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        rightPanel.setPreferredSize(new Dimension(200, 50));
		rightPanel.setVisible(true);
    }

    private void setupElements()
    {
        searchbar = new JTextField(20);


        searchButton = new JButton("SEARCH");
        searchButton.setContentAreaFilled(false);
        searchButton.setBackground(Color.GRAY);
        searchButton.setPreferredSize(new Dimension(100, 20));
        searchButton.setVisible(true);
        searchButton.setOpaque(true);
        searchButton.setFocusable(false);
    }

    private void setupListen()
    {
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                searchButtonPress();
            }
        });
    }


    private void searchButtonPress()
    {
        String search = searchbar.getText();
        List<Player> x;
        if(search != "");
        {
            x = ps.searchPlayersByName(search);        
        }
        
        updateResults(x);
    }

    //update the ui once a search is done
    private void updateResults(List<Player> x)
    {
        JButton current = new JButton(x.get(0).getName());
        current.setContentAreaFilled(false);
        current.setBackground(Color.GRAY);
        current.setPreferredSize(new Dimension(100, 20));
        current.setVisible(true);
        current.setOpaque(true);
        current.setFocusable(false);
        midPanel.add(current);
    }



}
