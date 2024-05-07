import greenfoot.*;  
import java.util.List;

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends AnimatedActor
{
    private static final int SPEED = 4;
    private int dotsEaten;
    private GreenfootImage image1;
    private int speedX = SPEED;
    private int speedY = SPEED;
    private MyWorlds world;
    public Pacman()
    {
        dotsEaten = 0;
        image1 = new GreenfootImage("Pacman2.png");
        int newWidth = 25;
        int newHeight = 25; 
        image1.scale(newWidth, newHeight);
        setImage(image1);

        
    }
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleKeyPresses();
        boundedMove();
        checkForDot();
        checkForCherries();
        checkForCollision();
        checkNextLevel();
        extraLife();
    }

    private void handleKeyPresses() {
        
        handleArrowKey("right", SPEED, 0);
        handleArrowKey("left", -SPEED, 0);
        handleArrowKey("up", 0, -SPEED);
        handleArrowKey("down", 0, SPEED);
    }

    private void handleArrowKey(String k, int sX, int sY) {
        if( Greenfoot.isKeyDown(k) ) {
            speedX = sX;
            speedY = sY;
            } 
        if (speedX>0 && speedY==0)
        {
            animate("Pacman",1,2);
        }
        else if (speedX<0 && speedY==0)
        {
            animate("Pacman",3,4);
        }
        else if (speedX==0 && speedY<0)
        {
            animate("Pacman",5,6);
        }
        else if (speedX==0 && speedY>0)
        {
            animate("Pacman",7,8);
        }
         
        
    }
    
    private void boundedMove() {
        setLocation(getX()+speedX, getY()+speedY);
        if( isTouching(BlackBlock.class ) || isTouching(BlueBlock.class ) || isTouching(GoldBlock.class ) ||
        isTouching(BrownBlock.class )) {
            setLocation(getX()-speedX, getY()-speedY);
        }
        speedX = 0;
        speedY = 0;
    }

    private void checkForDot()
    {
        Actor dot = getOneIntersectingObject(Dot.class);
        if (dot != null) {
            getWorld().removeObject(dot);
            
            MyWorlds world = (MyWorlds) getWorld();
            
            world.addScore(10); // Αυξάνουμε το σκορ κατά 10
            Greenfoot.playSound("collect-dots.mp3");

            dotsEaten++;
        }
    }
    private void checkForCherries()
    {
        Actor cherry = getOneIntersectingObject(Bonus.class);
        if (cherry != null) {
            getWorld().removeObject(cherry);
            
            MyWorlds world = (MyWorlds) getWorld();
            
            world.addScore(20); // Αυξάνουμε το σκορ κατά 20
            Greenfoot.playSound("bonus.mp3");
        }
    }


    private void extraLife()
    {
        Actor life = getOneIntersectingObject(Lives.class);
        
        if (life != null ) {
            MyWorlds world = (MyWorlds) getWorld();
             if (world.getLives() >= 1 && world.getLives() < 3) {
                getWorld().removeObject(life);
                // Αν υπάρχουν λιγότερες από 3 ζωές, προσθέτουμε μία ζωή
                world.earnLife();
            }
        }
    }
    
    private void checkForCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        Actor enemy2 = getOneIntersectingObject(SecondEnemy.class);
        Actor enemy3 = getOneIntersectingObject(ThirdEnemy.class);
        Actor enemy4 = getOneIntersectingObject(FourthEnemy.class);
        if (enemy != null || enemy2 != null || enemy3 != null || enemy4 != null) {
            MyWorlds world = (MyWorlds) getWorld();
            Greenfoot.playSound("enemy.mp3");
             if (world.getLives() > 1) {
                // Αν υπάρχουν περισσότερες από μία ζωές, αφαιρούμε μία ζωή
                world.loseLife();
                // Τοποθετούμε τους εχθρούς στην αρχική τους θέση
                List<Enemy> firsts = world.getObjects(Enemy.class);
                List<SecondEnemy> seconds = world.getObjects(SecondEnemy.class);
                List<ThirdEnemy> thirds = world.getObjects(ThirdEnemy.class);
                List<FourthEnemy> fourths = world.getObjects(FourthEnemy.class);
                for (Enemy first : firsts) {
                    first.setLocation(first.getInitialX(), first.getInitialY());
                }
                for (SecondEnemy second : seconds) {
                    second.setLocation(second.getInitialX(), second.getInitialY());
                }
                for (ThirdEnemy third : thirds) {
                    third.setLocation(third.getInitialX(), third.getInitialY());
                }
                for (FourthEnemy fourth : fourths) {
                    fourth.setLocation(fourth.getInitialX(), fourth.getInitialY());
                }
                // Τοποθετούμε τον Pacman στην αρχική του θέση
                setLocation(getInitialX(), getInitialY());
                setRotation(0); 
            } else {
                // Αν δεν υπάρχουν περισσότερες ζωές, το παιχνίδι τελειώνει
                world.gameOver();
                Greenfoot.setWorld(new Intro());
            }
        }
    }
    public void checkNextLevel()
    {
        MyWorlds world = (MyWorlds) getWorld();
        Actor next = getOneIntersectingObject(NextLevel.class);
        Actor end = getOneIntersectingObject(TheEnd.class);
        //if (dotsEaten==world.getDotsToPass() && (world instanceof FirstWorld))
        if (next != null && dotsEaten>=world.getDotsToPass() && (world instanceof FirstWorld))
        {
            Greenfoot.playSound("level-up.mp3");
            Greenfoot.setWorld(new SecondWorld(world.getLives(),world.getScore()));
            dotsEaten = 0;
        }
        else if (next != null && dotsEaten>=world.getDotsToPass() && (world instanceof SecondWorld))
        {
            Greenfoot.playSound("level-up.mp3");
            Greenfoot.setWorld(new ThirdWorld(world.getLives(),world.getScore()));
            dotsEaten = 0;
        }
        else if (end != null && dotsEaten>=world.getDotsToPass() && (world instanceof ThirdWorld))
        {
            Greenfoot.playSound("success.mp3");
            world.winMessage();
            Greenfoot.setWorld(new Intro());
        }
    }
    

}
