import greenfoot.*;  
import java.awt.font.FontRenderContext;
import java.awt.Graphics2D;


/**
 * This class provides objects that just show a bit of text on the screen.
 */
public class Text extends Actor
{

    public Text(){
        setImage(new GreenfootImage("Πατήστε Enter για να ξεκινήσετε", 24, Color.WHITE, Color.BLACK));
    }
    public Text(int length)
    {
        setImage(new GreenfootImage(length * 12, 16));
    }

    public Text(String text)
    {
        setImage(new GreenfootImage(text, 24, Color.WHITE, Color.BLACK));
    }

    public void setText(String text)
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(Color.WHITE);
        setImage(new GreenfootImage(text, 24, Color.WHITE, Color.BLACK));
        
    }
    
    /**
     * Adapt location to make placement left-justified.
     */
    public void setLocation(int x, int y)
    {
        super.setLocation(x + getImage().getWidth() / 2, y);
    }
}
