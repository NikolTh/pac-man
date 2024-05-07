import greenfoot.*;  
import java.util.Stack;

/**
 * Write a description of class SecondWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdWorld extends MyWorlds
{
    private int lives;
    private int score;
    private int k=0;
    
    private final static  String[] WORLD = {
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
            "BWWWWWWWWWWWWWWWWWWWGGGWWWWWWWWB",
            "BWWWWWWWWWWWWWWWWWWWGGGWWWWWWWWB",
            "BWWGGGGGGGGWWGGGGGWWGGGWWGGGGWWB",
            "BWWGGGGGGGGWWGGGGGWWGGGWWGGGGWWB",
            "BWWWWWWWWGGWWWWWWWWWWWWWWWWWWWWB",
            "BWWWWWWWWGGWWWWWWWWWWWWWWWWWWWWB",
            "BWWGGGGGGGGGGWWGGWWGGGGGGGGGGGGB",
            "BWWGGGGGGGGGGWWGGWWGGGWWWWWWWWWB",
            "BWWGGGWWWWWGGGGGGWWWWWWWWWWWWWWB",
            "BWWGGGWWWWWGGGGGGWWWWWWWGGGGGGGB",
            "BWWWWWWWWWWWWWWGGWWGGGGGGGGGGGGB",
            "BWWWWWWWWWWWWWWGGWWGGGGGWWGGGGGB",
            "BWWGGGWWGGGGGGGGGWWWWWWWWWGGWWWB",
            "BWWGGGWWGGGGGGGGGWWWWWWWWWGGWWWB",
            "BWWWWWWWGGWWWWWWWWWGGGGGGGGGWWGB",
            "BWWWWWWWGGWWWWWWWWWGGGGGGGGGWWGB",
            "BWWGGGWWGGWWWWWGGWWWWWWWWWWWWWGB",
            "BWWGGGWWGGGGGGGGGWWWWWWWWWWWWWGB",
            "BWWWWWWWGGGGGGGGGWWGGGGWWGGGWWGB",
            "BWWWWWWWWWWWWWWWWWWGGGGWWGGGWWGB",
            "BWWGGGWWWWWWWWWWWWWWWWWWWWWWWWGB",
            "BWWGGGWWGGGGGGGGGWWWWWWWWWWWWWGB",
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
        };
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ThirdWorld(int lives, int score)
    {    
        super(200,lives,score,3);
        //super(lives,score,3);
        createWorldFromTiles(WORLD);
        
        this.lives = lives; // Αρχικοποίηση των ζωών
        this.score = score; // Αρχικοποίηση των score
        createCounters ();
        prepare();
        
    }
    
    
    
    private void prepare()
    {
        Pacman pacman = new Pacman();
        addObject(pacman,345,297);
        pacman.setInitialXY(345,297);

        // Create dots
        int[][] dotPositions = {
                {310, 300}, {285, 300}, {260, 300}, {235, 300}, {210, 300}, 
                {185, 300}, {160, 300}, {245, 275}, {125, 300}, {100, 300}, 
                {75, 300}, {45, 300}, {45, 325}, {45, 350}, {45, 375}, {45, 400}, 
                {45, 425}, {45, 450}, {45, 475}, {45, 500}, {45, 275}, {45, 250}, 
                {45, 225}, {45, 200}, {45, 175}, {45, 150}, {45, 125}, {45, 100}, 
                {45, 75}, {45, 50}, {75, 50}, {100, 50}, {125, 50}, {150, 50}, 
                {175, 50}, {200, 50}, {225, 50}, {250, 50}, {275, 50}, {300, 50}, 
                {325, 50}, {350, 50}, {375, 50}, {400, 50}, {425, 50}, {450, 50}, 
                {475, 50}, {475, 75}, {475, 100}, {475, 125}, {475, 150}, 
                {445, 150}, {445, 175}, {445, 200}, {445, 225}, {445, 250}, 
                {445, 275}, {445, 300}, {445, 325}, {445, 350}, {445, 375}, 
                {445, 400}, {445, 425}, {445, 450}, {445, 475}, {445, 500}, 
                {445, 525}, {445, 550}, {470, 550}, {495, 550}, {520, 550}, 
                {545, 550}, {570, 550}, {595, 550}, {620, 550}, {645, 550}, 
                {670, 550}, {695, 550}, {720, 550}, {720, 525}, {720, 500}, 
                {720, 475}, {720, 450}, {720, 425}, {720, 400}, {720, 375}, 
                {720, 350}, {420, 400}, {395, 400}, {370, 400}, 
                {345, 400}, {320, 400}, {295, 400}, {270, 400},  
                {295, 425}, {320, 425}, {345, 425}, {470, 250}, {495, 250}, 
                {520, 250}, {545, 250}, {570, 250}, {570, 225}, {595, 225}, 
                {620, 225}, {645, 225}, {670, 225}, {695, 225}, 
                {745, 225}, {420, 150}, {470, 350}, {495, 350}, {520, 350}, 
                {545, 350}, {570, 350}, {595, 350}, {620, 350},  
                {470, 450}, {495, 450}, {520, 450}, {545, 450}, {570, 450}, 
                {595, 450}, {620, 450}, {645, 450}, {670, 450}, {695, 450}, 
                {420, 525}, {395, 525}, {370, 525}, {345, 525}, {320, 525}, 
                {295, 525}, {270, 525}, {245, 525}, {220, 525}, {195, 525}, 
                {170, 525}, {170, 550}, {170, 500}, {145, 500}, {120, 500}, 
                {95, 500}, {70, 500}, {45, 525}, {170, 475}, 
                {170, 450}, {170, 425}, {170, 400}, {145, 400}, {120, 400}, 
                {95, 400}, {70, 400}, {170, 375}, {170, 350}, {170, 325}, 
                {170, 275}, {195, 250}, {220, 250}, {245, 250}, 
                {220, 275}, {195, 275}, {395, 150}, {370, 150}, {345, 150}, 
                {320, 150}, {295, 150}, {345, 175}, {295,150}, {295, 125}, 
                {295, 100}, {295, 75},{505,150},{535,150},
                {565,150},{595,125},{595,150},{625,150},{655,150},{685,150},
                {745,125},{745,100},{745,75},{715,45},{685,45},{655,45},
                {625,45},{595,45},{595,70},{595,95},{75,150},{100,150},{125,150},
                {150,150},{175,150}, {715,150},{595,525},{595,500},{595,475},
                {745,150}

            };
        for (int[] pos : dotPositions) {
            addObject(new Dot(), pos[0], pos[1]);
        }

        for (int i=0;i<lives;i++){
            Lives life = new Lives();
            addObject(life,700+i*30,600);
            livesList.add(life);

        }

        Enemy enemy = new Enemy();
        addObject(enemy,49,53);
        enemy.setInitialXY(49,53);
        ThirdEnemy enemy2 = new ThirdEnemy();
        addObject(enemy2,270,395);
        enemy2.setInitialXY(270,395);

        

        SecondEnemy enemy4 = new SecondEnemy();
        addObject(enemy4,719,552);
        enemy4.setInitialXY(719,552);
        Enemy enemy5 = new Enemy();
        addObject(enemy5,456,456);
        enemy5.setInitialXY(456,456);

        SecondEnemy secondEnemy3 = new SecondEnemy();
        addObject(secondEnemy3,46,296);
        secondEnemy3.setInitialXY(46,296);

        ThirdEnemy thirdEnemy3 = new ThirdEnemy();
        addObject(thirdEnemy3,47,496);
        thirdEnemy3.setInitialXY(47,496);
        SecondEnemy secondEnemy4 = new SecondEnemy();
        addObject(secondEnemy4,292,148);
        secondEnemy4.setInitialXY(292,148);
        Enemy enemy7 = new Enemy();
        addObject(enemy7,604,47);
        enemy7.setInitialXY(604,47);
        FourthEnemy fourthEnemy = new FourthEnemy();
        addObject(fourthEnemy,445,550);
        fourthEnemy.setInitialXY(445,550);
        FourthEnemy fourthEnemy2 = new FourthEnemy();
        addObject(fourthEnemy2,167,450);
        fourthEnemy2.setInitialXY(167,450);

        Bonus bonus = new Bonus();
        addObject(bonus,270,425);

        Bonus bonus2 = new Bonus();
        addObject(bonus2,745,45);

        Bonus bonus4 = new Bonus();
        addObject(bonus4,45,550);
        Bonus bonus5 = new Bonus();
        addObject(bonus5,345, 200);
        Bonus bonus6 = new Bonus();
        addObject(bonus6,620, 325);

        Lives lives3 = new Lives();
        addObject(lives3,170,250);
        Lives lives5 = new Lives();
        addObject(lives5,200,150);
        Lives lives6 = new Lives();
        addObject(lives6,720,225);

        //Bonus bonus3 = new Bonus();
        //addObject(bonus3,749,348);
        //removeObject(bonus3);
        TheEnd theEnd = new TheEnd();
        addObject(theEnd,755,348);
        
    }


}
