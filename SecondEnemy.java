import greenfoot.*;  

/**
 * Write a description of class SecondEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondEnemy extends AnimatedActor
{
    private int direction = 1;
    private static final int SPEED = 3;
    private GreenfootImage image1;
    private GreenfootImage image2;
    public SecondEnemy()
    {
        image1 = new GreenfootImage("SecondEnemy1.png");
        image2 = new GreenfootImage("SecondEnemy5.png");
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
        isTouching(GoldBlock.class) || isTouching(BrownBlock.class ) ){
            direction *= -1;
            
            setLocation(getX() + direction*SPEED, getY());
  
        }
        else{
            setLocation(getX() + direction*SPEED, getY());
        }
        if (direction < 0)
            animate ("SecondEnemy",5,8);
        else
            animate ("SecondEnemy",1,4);
    }
    
    
}
