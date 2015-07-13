import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

// The BoatRace Class is the JFrame of which everything is drawn in.
public class BoatRace extends JFrame 
{
   public BoatRace()
   {
            // The Island class is the game instance.
            add(new Island());
      
            // Title on top of window, exit program on close, visible, not resizable, and set to a specific size.
            setTitle("Boat Race");
            setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            setVisible( true );
            setResizable( false);
            setSize(900,700);
   }
  
   // The BoatRace class is where the program is executed. First stop: the menu screen.
   public static void main (String[] args) 
   {
            new Menu();
   }
 }