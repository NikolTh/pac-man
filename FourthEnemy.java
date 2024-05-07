import greenfoot.*; 

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FourthEnemy extends AnimatedActor
{
    private int direction = 1;
    private static final int SPEED = 3;
    private GreenfootImage image1;
    private GreenfootImage image2;
    public FourthEnemy()
    {
        image1 = new GreenfootImage("FourthEnemy1.png");
        image2 = new GreenfootImage("FourthEnemy3.png");
        int newWidth = 25; 
        int newHeight = 25; 
        image1.scale(newWidth, newHeight);
        image2.scale(newWidth, newHeight);
        setImage(image1);
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveEnemy();
    }
    private void moveEnemy()
    {
        if( isTouching(BlackBlock.class) || isTouching(BlueBlock.class) ||
        isTouching(GoldBlock.class) || isTouching(BrownBlock.class )){
            direction *= -1;
            
            setLocation(getX(), getY() + direction*SPEED);
  
        }
        else{
            setLocation(getX(), getY() + direction*SPEED);
        }
        if (direction < 0)
            animate ("FourthEnemy",1,2);
        else
            animate ("FourthEnemy",3,4);
    }
}


