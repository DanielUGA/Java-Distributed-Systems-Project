import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;

public class Island extends JPanel implements ActionListener, KeyListener 
{

   private Timer timer;
   private Boat boat;
   private Boat boat2;
   private boolean ingame;

   public void paintComponent (Graphics g) 
   {
    super.paintComponent(g);  
           
           if (ingame)
           {
      // Repaint() in actionPerformed draws the island and boat (including displacement) per each timer tick.
         Color c0 = Color.cyan;
            g.setColor( c0 );
            g.fillRect(50, 100, 750, 500);
            Color c1 = Color.green; 
              g.setColor( c1 ); 
              g.fillRect( 150, 200, 550, 300 ); // island 
         Color c2 = Color.blue; 
             g.setColor( c2 ); 
             g.drawRect(50, 100, 750, 500);  // outer edge of lake 
             g.drawRect(150, 200, 550, 300); // inner edge of lake 
         Color c3 = Color.yellow; 
             g.setColor( c3 ); 
             g.drawRect( 100, 150, 650, 400 ); // mid-lane marker bouys 
         Color c4 = Color.black; 
             g.setColor( c4 ); 
             g.drawLine( 425, 500, 425, 600 ); // start line
             
        Graphics2D g2d = (Graphics2D)g;
        
        // If visible is set to true, then continue to draw them.
        if (boat.isVisible())
        {
        g2d.drawImage(boat.getImage(), boat.getX(), boat.getY(), this);
        }
        
        if (boat2.isVisible())
        {
        g2d.drawImage(boat2.getImage(), boat2.getX(), boat2.getY(), this); 
        }
        
        
        Toolkit.getDefaultToolkit().sync();
        
        // remove whatever was stored in g so that it can be used for the next repaint.
        g.dispose();
             
        }
             // If ingame is set to false. This only occurs when the boats have collided.
             else
             {
               // Regardless of if the boats have crashed or not, draw the island anyway.
                  Color c0 = Color.cyan;
                  g.setColor( c0 );
                  g.fillRect(50, 100, 750, 500);
               Color c1 = Color.green; 
                 g.setColor( c1 ); 
                 g.fillRect( 150, 200, 550, 300 ); 
                Color c2 = Color.blue; 
                g.setColor( c2 ); 
                g.drawRect(50, 100, 750, 500);   
                g.drawRect(150, 200, 550, 300);  
                Color c3 = Color.yellow; 
                g.setColor( c3 ); 
                g.drawRect( 100, 150, 650, 400 ); 
               Color c4 = Color.black; 
                g.setColor( c4 ); 
                g.drawLine( 425, 500, 425, 600 ); 
             
             
                // show some text telling the player(s) that the game is over because they collided their boats.
                String gameOverMsg = "The Boats Crashed! Game Over!"; 
                Font large = new Font("Helvetica", Font.BOLD, 36);
                g.setColor(Color.black);
                g.setFont(large);
                
                // Draw it around the middle of the screen.
                g.drawString(gameOverMsg, 150, 300);
             }
   
   }
   
   
   // every timer tick 
   public void actionPerformed (ActionEvent e) 
   {
      
      // boat.move changes the X and Y so the paintComponent knows where to draw it.
      boat.move();
      boat2.move();
      checkCollision();
      repaint ();
   }

   public Island()
   {
       
       // Add KeyListener to listen for keys being pressed
       addKeyListener(this);
       setFocusable(true);
       
       ingame = true;
       
       // Initialise player 1 and player 2
       boat = new Boat(1);
       boat2 = new Boat(2);
       
       // After player 2 has been created, set it 50 pixels down from player 1.
       int player2Starting = boat2.getY();
       boat2.setY (player2Starting + 50);
       
       // 20 milliseconds allows for speed to increment by 1 without making the boat go too fast too soon.
       timer = new Timer(20, this);
       timer.start();
   }

   
            // Key pressed triggers when the key is pressed down.
           public void keyPressed(KeyEvent e) 
           {
             int keyPress = e.getKeyCode();
           
            if( keyPress == e.VK_A) 
            { 
                 // To turn the boat, the direction variable must be changed. 
                 // direction is mapped like a 4x4 grid. 16 images total.
                 int d = boat.getdirection();
                 boat.setdirection( d - 1 );
            }
            if ( keyPress == e.VK_D)
            {
                 int d = boat.getdirection();
                 boat.setdirection( d + 1 );
            }
             if ( keyPress == e.VK_W)
            {
            
               // each time speed is incremented, the rate at which the boat moves along the axis
               // is increased by 2 per timer tick.
                int s = boat.getspeed();
                boat.setspeed( s + 1 );
                                            
            }
            if ( keyPress == e.VK_S)
            {
               int s = boat.getspeed();
               boat.setspeed( s - 1 );
            }
            
            // Boat 2s controls here.
            if ( keyPress == e.VK_J)
            {
                int d = boat2.getdirection();
                 boat2.setdirection( d - 1 );
            }
            if (keyPress == e.VK_L)
            {
               int d = boat2.getdirection();
                 boat2.setdirection( d + 1 );
            }
            if (keyPress == e.VK_I)
            {
               int s = boat2.getspeed();
                boat2.setspeed( s + 1 );
            }
            if (keyPress == e.VK_K)
            {
                int s = boat2.getspeed();
               boat2.setspeed( s - 1 );
            }
            
            
            // There's probably a better way to code this, but it works for now
            
            // Stops the direction and speed from exceeding/deceeding it's limits.
            
            // Direction must not exceed 15 as there are only 16 images.
            // Once it reaches 16, it sets to 0 which is the next image clockwise.
             if (boat.getdirection() > 15) {
                   boat.setdirection(0);
                   }
                   if (boat.getdirection() < 0) {
                   boat.setdirection(15);
                   }
                   
             // I wanted to make reversing around the course undesirable.
                   if (boat.getspeed() < -1) 
                   {
                   boat.setspeed(-1);
                   }
                   
             // I also wanted to set a speed limit so the turning angle was not an issue.
                   if (boat.getspeed() > 3)
                   {
                   boat.setspeed(3);
                   }
                   
              if (boat2.getdirection() > 15) {
                   boat2.setdirection(0);
                   }
                   if (boat2.getdirection() < 0) {
                   boat2.setdirection(15);
                   }
                   if (boat2.getspeed() < -1) 
                   {
                   boat2.setspeed(-1);
                   }
                   if (boat2.getspeed() > 3)
                   {
                   boat2.setspeed(3);
                   }
      }
           
               
           
           // Mandatory methods.
            public void keyReleased(KeyEvent e){} 
            public void keyTyped(KeyEvent e) {} 
                  
                  
      // checkCollision is called in actionPerformed, so it's checked every tick of the timer.             
      public void checkCollision() 
      {
      
         // The size of each boat is retrieved here to check.
         Rectangle r1 = boat.getBounds();
         Rectangle r2 = boat2.getBounds();
          
         // intersects is a unique command used with getBounds, which checks if the X and Y coordinates are the same. 
         if (r1.intersects(r2)) 
         {
         
         // AudioInputStream is used to play sounds.
         try
          {
          // Get the audio file.
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./crash.wav").getAbsoluteFile());
        // Set it as an audio clip of a specific length.
        Clip crash = AudioSystem.getClip();
        // Enable it to be played.
        crash.open(audioInputStream);
        // Play it! 
        crash.start();
         } 
         // The errors are printed incase the wav file is not compatible or it cannot find it. 
         catch(Exception ex) 
         {
        ex.printStackTrace();
         }
         // The boats are set to not visible so next time repaint() is called, it does not draw them.
            boat.setVisible(false);
            // A very poor way of preventing the crash sound from playing multiple times.
            // After it's played once, boat is moved so it does not intersect boat2 anymore
            // Therefore it does not play the crash sound.
            boat.setY(1000);
            boat2.setVisible(false);
            // ingame is a boolean which when set to false, assumes the boats have crashed and triggers a message
            // in the PaintComponent.
            ingame = false;
         }
        
      }
}