import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Beginning of Program
public class Showcase extends JPanel implements ActionListener 
{
// Need to establish that Images will be used.
   private ImageIcon images[];
   // How many images, which one to start from, how fast the animation will run through each one in sequence.
   int totalImages = 16, currentImage = 0, animationDelay = 100;
   // Javax.swing.timer comes in here.
   private Timer animationTimer;
   public Showcase() 
   {
      // New instance of main, where we populate the variables with the image name. 
       images = new ImageIcon[totalImages];
       
       // Creates 16 images for use later in the program
       for (int i = 0; i < images.length; i++) 
         images[i] = new ImageIcon("Player1 " + i + ".gif");
         
      animationTimer = new Timer (animationDelay, this);
      animationTimer.start();
   }

    // all graphics need the paintComponent
  public void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
      // When the current image is image 16, set it back to 0.
        if (currentImage >= images.length) 
         {
            currentImage = 0;
         }
      
      // Increment the image number by 1 and draw it.
      currentImage++;
     
      images[currentImage].paintIcon(this, g, 35, 35);
      currentImage = (currentImage + 1) % totalImages;
  
  }

   // After every timer tick, call the PaintComponent again
  public void actionPerformed(ActionEvent e) 
  {
    repaint();
  }
  
  public static void main(String args[])
  {
    // Create a Frame
    JFrame app = new JFrame("Boat Showcase");
    // Add an instance of Showcase (a JPanel) to the Frame
    Showcase anim = new Showcase();
     // Set the size of the application window
    app.setSize(150,150);
    app.add(anim);
    // Set them as visible
    app.setVisible(true);
    anim.setVisible(true);
    // Prevent user from resizing the frame.
    app.setResizable(false);
    // Close the application down when the user closes the window
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}