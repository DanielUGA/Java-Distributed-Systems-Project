import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Boat 
   {
      private int direction;
      private int playerNum;
      private int boatImageNum;
      private int width, height; 
      private boolean visible;
      private int x, y, dx, dy;
      private int speed;
      private Image image; 
      
      public Boat(int whatNumberAmI) 
      {
      // Boat's starting position, starting image (left facing) and setting of variables
         boatImageNum = 1;
         playerNum = whatNumberAmI;
         ImageIcon boatImage = new ImageIcon("player" + playerNum + " " + boatImageNum + ".gif");
         image = boatImage.getImage(); 
         width = image.getWidth(null);
        height = image.getHeight(null);
         visible = true;
          x = 450;
          y = 500;
          dx = 0;
          dy = 0;
          direction = 12;
          speed = 0;
        }
 

// Called in the island class in ActionPerformed. Updates the boat location every 5 milliseconds
   public void move()
   {
          // If a boat is a new direction, then it's speed in that new direction should still be the same as before.
         if (direction == 0) {
          boatImageNum = 5;
           y = y - 2 * speed;
          }
          else if (direction == 1) {
          boatImageNum = 6;
            y = y - 2 * speed;
            x = x + 1 * speed;
          }
          else if (direction == 2) {
          boatImageNum = 7;
            y = y - 2 * speed;
            x = x + 2 * speed;
          }
          else if (direction == 3) {
          boatImageNum = 8;
            y = y - 1 * speed;
            x = x + 2 * speed;
          }
          else if (direction == 4) {
          boatImageNum = 9;
            x = x + 2 * speed;
          }
          else if (direction == 5) {
          boatImageNum = 10;
            y = y + 1 * speed;
            x = x + 2 * speed;
          }
          else if (direction == 6) {
          boatImageNum = 11;
            y = y + 2 * speed;
            x = x + 2 * speed;
          }
          else if (direction == 7) {
          boatImageNum = 12;
            y = y + 2 * speed;
            x = x + 1 * speed;
          }
          else if (direction == 8) {
          boatImageNum = 13;
            y = y + 2 * speed;
          }
          else if (direction == 9) {
          boatImageNum = 14;
            y = y + 2 * speed;
            x = x - 1 * speed;
          }
          else if (direction == 10) {
          boatImageNum = 15;
            y = y + 2 * speed;
            x = x - 2 * speed;
          }
          else if (direction == 11) {
          boatImageNum = 16;
            y = y + 1 * speed;
            x = x - 2 * speed;
          }
          else if (direction == 12) {
           boatImageNum = 1;
            x = x - 2 * speed;
          }
          else if (direction == 13) {
          boatImageNum = 2;
            y = y - 1 * speed;
            x = x - 2 * speed;
          }
          else if (direction == 14) {
          boatImageNum = 3;
            y = y - 2 * speed;
            x = x - 2 * speed;
          }
          else if (direction == 15) {
          boatImageNum = 4;
            y = y - 2 * speed;
            x = x - 1 * speed;
          }  
      
           ImageIcon boatImage = new ImageIcon("Player" + playerNum + " " + boatImageNum + ".gif");
            image = boatImage.getImage(); 
    }
    
    // Get and set methods which are called from the Island class.
   
   public int getX() 
   {
        return x;
    }

    public int getY() 
    {
        return y;
    }
    
    public void setY( int why)
    {
        y = why;
    }
    
    public int getPlayerNum()
    {
         return playerNum;
    }
    
    public void setPlayerNum( int playerPosition )
    {
         playerNum = playerPosition;
    }

    public Image getImage() 
    {
        return image;
    }
    
    public int getdirection()
    {
       return direction;
    }
    
    public void setdirection( int dir )
    {
       direction = dir;
    }
    
    public int getspeed()
    {
       return speed;
    }
    
    public void setspeed (int go)
    {
       speed = go;
    }
    
    // We need to be able to set visibility to false for when the boats collide.
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
     public boolean isVisible() {
        return visible;
    }
    
    // width/2 and height/2 is an easy but not an intricate way of handling invisble space on each image.
    // Allows for some overlap before detecting collision
     public Rectangle getBounds() {
        return new Rectangle(x, y, width/2, height/2);
    }
}