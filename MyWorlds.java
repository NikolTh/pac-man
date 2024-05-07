import greenfoot.*; 
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Write a description of class MyWorlds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MyWorlds extends World
{

    private int level;
    private int score;
    public Text scoreLabel;
    // Υπόλοιπο ζωών
    private int lives;
    public List<Lives> livesList = new ArrayList<>();
    
    private int dotsToPass;
    
    private final static int SWIDTH = 800;
    private final static int SHEIGHT = 625;
    private final static int WWIDTH = 1200;
    private final static int TWIDTH = 25;
    private final static int THEIGHT = TWIDTH;
    private final static int TILEOFFSET = TWIDTH/2;
    private static final int CELL_SIZE = 20;
    /**
     * Constructor for objects of class MyWorlds.
     * 
     */
    public MyWorlds(int dotsToPass, int lives, int score,int level)
    //public MyWorlds(int lives, int score,int level)
    {    
        super(SWIDTH, SHEIGHT, 1, false);
        this.dotsToPass=dotsToPass;
        this.lives=lives;
        this.score=score;
        this.level = level;
        
    }
    public MyWorlds()
    {    
        super(SWIDTH, SHEIGHT, 1, false);
    }

    public void createWorldFromTiles(String[] world) {
        for( int i=0; i < world.length; i++ ) {
            for( int j=0; j < world[i].length(); j++ ) {
                addActorAtTileLocation(world[i].charAt(j), j, i);
            }
        }
    }

    public void addActorAtTileLocation(char c, int x, int y) {
        Actor tile = null;
        switch(c) {
            case 'W':
            tile = new WhiteBlock();
            break;
            case 'B':
            tile = new BlackBlock();
            break;
            case 'U':
            tile = new BlueBlock();
            break;
            case 'G':
            tile = new GoldBlock();
            break;
            case 'I':
            tile = new BrownBlock();
            break;
        }
        if( tile != null) addObject(tile, TILEOFFSET+x*TWIDTH,
                TILEOFFSET+y*THEIGHT);
    }
    
    public void gameOver()
    {

        PopUp gameover = new PopUp("Game Over", score);
        addObject(gameover, 400,300);
        Greenfoot.playSound("gameover.mp3");
        Greenfoot.delay(50);
        return;
    }
    public void loseLife() {
        if (lives > 1) {
            lives--;
            Greenfoot.delay(50); // Καθυστέρηση για 50 act εντολές
            removeObject(livesList.remove(livesList.size() - 1));
            
        }
    }
    public void earnLife() {
        if (lives < 3) {
        lives++;
        
        // Ελέγχουμε αν η λίστα ζωών έχει τουλάχιστον ένα αντικείμενο
        if (!livesList.isEmpty()) {
            // Παίρνουμε το τελευταίο αντικείμενο στη λίστα
            Lives lastLife = livesList.get(livesList.size() - 1);
            
            // Παίρνουμε τις συντεταγμένες του τελευταίου αντικειμένου
            int lastX = lastLife.getX();
            int lastY = lastLife.getY();
            
            // Υπολογίζουμε τις νέες συντεταγμένες για το νέο αντικείμενο ζωής
            int newX = lastX + 30;
            int newY = lastY;
            
            // Δημιουργούμε τη νέα ζωή
            Lives newLife = new Lives();
            
            // Προσθέτουμε το νέο αντικείμενο ζωής στον κόσμο
            addObject(newLife, newX, newY);
            
            // Προσθέτουμε τη νέα ζωή στη λίστα ζωών
            livesList.add(newLife);
            
            Greenfoot.playSound("extralife.mp3");
        }
    }
    }
    
    public int getLives() {
        return lives;
    }
    public void addScore(int points)
    {
        score = score + points;
        scoreLabel.setText ("Score: " + score + "      ");
    }
    public int getScore()
    {
        return score;
    }
    public void createCounters()
    {
        scoreLabel = new Text("Score: " + score + "      ");
        addObject (scoreLabel, 45, 600);
    }
    public int getDotsToPass(){
        return this.dotsToPass;
    }
     public void winMessage()
    {
        PopUp winner = new PopUp("You won!!",score);
        addObject(winner, 400,300);
        Greenfoot.delay(50);
        return;
    }
}
