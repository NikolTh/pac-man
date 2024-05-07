import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheEnd extends AnimatedActor
{
    
    public TheEnd()
    {
        GreenfootImage image = getImage();
        image.scale(20, 20);
    }
    /**
     * Act - do whatever the TheEnd wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animate ("final",1,3);
    }
}
