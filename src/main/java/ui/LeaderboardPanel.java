package ui;
import javax.swing.*;
import java.awt.*;
public class LeaderboardPanel 
{
    //these will be the main panel and frame, i just thought 'this' was easier to type
    private JFrame thisFrame;
    private JPanel thisPanel;

    private JPanel topPanel, rightPanel, leftPanel;
    

    public LeaderboardPanel()
    {
        thisFrame = new JFrame("Leaderboard");
        setupPanels();
        setupFrame();
    }

    //set some default behaviors and such
    private void setupFrame()
    {
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.setMinimumSize(new Dimension(750, 750));
        thisFrame.setResizable(false);
        thisFrame.setVisible(true);
        thisFrame.setLocationRelativeTo(null);

        
        thisFrame.add(topPanel, BorderLayout.NORTH);
        thisFrame.add(thisPanel, BorderLayout.CENTER);

        
    }

    private void setupPanels()
    {
        //Center panel setup, which is for displaying the juicy stuff
        thisPanel = new JPanel();
        thisPanel.setLayout(new BoxLayout(thisPanel, BoxLayout.Y_AXIS));
        thisPanel.setBackground(Color.BLACK);
        thisPanel.setVisible(true);


        //Top panel, which will have options for different ways to display the leaderboards
        topPanel = new JPanel();
        topPanel.setBackground(Color.CYAN);
        topPanel.setVisible(true);
        topPanel.setSize(thisFrame.getWidth(), 200);
        

    }
}
