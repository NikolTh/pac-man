import greenfoot.*; 

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Actor
{
   
    private int frame = 0;
    private GreenfootImage image;
    private String extension = ".png";
    private int speed = 5;
    private int speedCounter = 0;
   
 
   public void animate(String name, int first, int last)
    {
        if (speedCounter >= speed)
        {
            speedCounter = 0;
            if (frame < first || frame >= last)
            {
                frame = first;
            }
            else
            {
                frame++;
            }
            image = new GreenfootImage(name + frame + extension);
            image.scale(25, 25);
            
            setImage(image); 
            
        }

        else
        {
            speedCounter++;
        }
        Greenfoot.delay(1/2);
        
    }
    
    private int initialX;
    private int initialY;
    

    public int getInitialX() {
        return initialX;
    }
    public int getInitialY() {
        return initialY;
    }
    public void setInitialXY(int x,int y) {
        initialX = x;
        initialY = y;
    }
}
  