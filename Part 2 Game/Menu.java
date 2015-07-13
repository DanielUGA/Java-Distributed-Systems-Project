import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


// The menu class is called by main in BoatRace.
public class Menu extends JFrame implements ActionListener
{
   // the "play game" button creates the BoatRace JFrame and adds Island to it 
   private JButton PlayGameButton = new JButton("Play Game");
   // A "how to play" button to inform users how to control the boats.
   private JButton Instructions = new JButton("How to play");
   private JFrame MenuFrame = new JFrame("Game Menu");
   // A panel needed to be made to have 2 buttons using the GridLayout
   private JPanel MenuPanel = new JPanel();
   
   // 0 rows and 2 columns. If I wanted the buttons on top of eachother, I would use GridLayout (2, 0);
   private GridLayout menuLayout = new GridLayout(0,2);
   
    public Menu()
   {
         // Add the JPanel to the Frame.
         MenuFrame.add(MenuPanel);
         // Add the GridLayout to the panel, so anything created gets it's own portion of the frame.
         MenuPanel.setLayout(menuLayout);
         MenuFrame.setVisible( true );
         MenuFrame.setResizable( false);
         MenuFrame.setSize(300,300);
         // Added action listeners for both buttons so something happens when they are clicked.
         PlayGameButton.addActionListener(this);
         Instructions.addActionListener(this);
         // Add the buttons to the Panel Grid. They take up half of the Frame width each.
         MenuPanel.add(PlayGameButton);
         MenuPanel.add(Instructions);
         
   }
   
    public void actionPerformed (ActionEvent e)
   {
         Object src = e.getSource();
         // When "play game" is clicked, create a new BoatRace, which adds a new Island game instance.
          if (src == PlayGameButton)
         {
            new BoatRace();
            // close the Menu screen, but don't stop the application running.
            MenuFrame.dispose();
            
         }
         if (src == Instructions)
         {
            // A pop up explaining the controls for each player.
            JOptionPane.showMessageDialog(null,"Use the WASD keys (for player 1) or the IJKL keys (for player 2) to drive your boat clockwise around the track.");
         }
   }
   
   
}