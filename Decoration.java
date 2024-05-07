import greenfoot.*; 

/**
 * Write a description of class Decoration here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Decoration  extends Actor
{
    private int x;

    /**
     * Constructor for objects of class Decoration
     */
    public Decoration(String imageName,int x, int y)
    {
        GreenfootImage image=new GreenfootImage(imageName);
        image.scale(x,y);
        setImage(image);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        return x + y;
    }
}
