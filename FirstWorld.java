import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstWorld extends MyWorlds
{
 
    private final static  String[] WORLD = {
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
            "BWWWWWWWWWWWWWWWWWWWWWWWWUUUUUUB",
            "BWWWWWWWWWWWWWWWWWWWWWWWWUUUUUUB",
            "BWWUUUUUUUUWWUUUUUUUUUUWWUUUUUUB",
            "BWWUUUUUUUUWWUUUUUUUUUUWWUUUUUUB",
            "BWWWWWWWWWWWWWWWWWWWWWWWWWWWWWUB",
            "BWWWWWWWWWWWWWWWWWWWWWWWWWWWWWUB",
            "BUUUWWUUUUUUUUUWWUUUUUUUUUUUWWUB",
            "BUUUWWUUUUUUUUUWWUUUUUUUUUUUWWUB",
            "BUUUWWUUUUUUUUUWWWWWWWWWWWWWWWUB",
            "BUUUWWUUUUUUUUUWWWWWWWWWWWWWWWUB",
            "BUUUWWWWWWWWWUUWWUUUUUUUUUUUWWUB",
            "BUUUWWWWWWWWWUUWWUUUUUUUUUUUWWUB",
            "BUUUWWUUUUUUUUUWWWWWWWWWWWWWWWUB",
            "BUUUWWUUUUUUUUUWWWWWWWWWWWWWWWUB",
            "BWWWWWWWUUUUUUUWWUUUUUUUUUUUWWUB",
            "BWWWWWWWUUWWWWWWWWWUUUUUUUUUWWUB",
            "BWWUUUWWUUWWWWWWWWWUUUUUUUUUWWUB",
            "BWWUUUWWUUWWUUUUUWWUUUUUUUUUWWUB",
            "BUUUUUWWUUWWUUUUUWWUUUUUUUUUWWUB",
            "BUUUUUWWWWWWWWWWWWWWWWWWWWWWWWUB",
            "BUUUUUWWWWWWWWWWWWWWWWWWWWWWWWUB",
            "BUUUUUWWUUUUUUUUUUUUUUUUUUUUUUUB",
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
        };
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public FirstWorld()
    {   
        super(167,3,0,1);
        //super(3,0,1);
        createWorldFromTiles(WORLD);
        
        createCounters ();
        prepare();
    }
    

    
    private void prepare()
    {

        Pacman pacman = new Pacman();
        addObject(pacman,310, 300);
        pacman.setInitialXY(310, 300);

        // Create dots
        int[][] dotPositions = {
                {285, 300}, {260, 300}, {235, 300}, {210, 300}, 
                {185, 300}, {160, 300}, {120, 175},{120, 200},
                {120, 225}, {120, 250},{120, 275}, {120, 300},{120, 325},
                {120, 350},{120, 375},{45, 400}, 
                {45, 150}, {45, 125}, {45, 100}, 
                {45, 75}, {45, 50}, {75, 50}, {100, 50}, {125, 50}, {150, 50}, 
                {175, 50}, {200, 50}, {225, 50}, {250, 50}, {275, 50}, {300, 50}, 
                {325, 50}, {350, 50}, {375, 50}, {400, 50}, {425, 50}, {450, 50}, 
                {475, 50}, {500, 50}, {525, 50},{550, 50},{575, 50}, {475, 150}, 
                {445, 150}, {445, 250}, {420, 250}, {420, 350}, 
                {445, 350},  
                {445, 425},{420, 425}, {445, 450}, {445, 475}, 
                {445, 500}, {445, 525}, {720, 525}, {720, 500}, 
                {720, 475}, {720, 450}, {720, 425}, {720, 400}, {720, 375}, 
                {720, 350}, 
                {295, 425}, {320, 425}, {345, 425}, {470, 250}, {495, 250}, 
                {520, 250}, {545, 250}, {570, 250},  
                {420, 150}, {470, 350}, {495, 350}, {520, 350}, 
                {545, 350}, {570, 350}, {595, 350},{645, 350},{670, 350},
                {695, 350},{570, 250}, {595, 250},{620, 250},{645, 250},
                {670, 250},{695, 250},

                {420, 525}, {395, 525}, {370, 525}, {345, 525}, {320, 525}, 
                {295, 525}, {270, 525}, {245, 525}, {220, 525}, {195, 525}, 
                {170, 525},  {170, 500}, 
                {470, 525},{495, 525},{520, 525},{545, 525},{570, 525},
                {595, 525}, {620, 525}, {645, 525}, {670, 525}, {695, 525}, 

                {170, 475}, 
                {170, 450}, {170, 425}, {170, 400}, {145, 400}, {120, 400}, 
                {95, 400}, {70, 400}, {395, 150}, {370, 150}, {345, 150}, 
                {320, 150},  {295,150}, {295, 125}, 
                {295, 75},{505,150},{535,150},{595,70},{595,95},{75,150},{100,150},{125,150},
                {150,150},{175,150},{200,150},{225,150},{250,150},{275,150},{370,425},{395,425},
                {395, 400},{395,375},{395, 350},{395, 325},{395,300},{395,275}, {395,250}, {395,225},
                {395,200},{395,175},{720, 325},{720,300},{720,275}, {720,250}, {720,225},
                {720,200},{720,175},{720,150},{695,150},{670,150},{645,150},{620,150},{595,150},
                {570,150},{595,125}, {47,425},{270,450},{270,475},{270,500}
            };
        for (int[] pos : dotPositions) {
            addObject(new Dot(), pos[0], pos[1]);
        }
                
        Lives lives = new Lives();
        addObject(lives,700,600);
        livesList.add(lives);
        Lives lives2 = new Lives();
        addObject(lives2,730,600);
        livesList.add(lives2);
        Lives lives3 = new Lives();
        addObject(lives3,760,600);
        livesList.add(lives3);
        Bonus bonus = new Bonus();
        addObject(bonus,295,100);
        Bonus bonus2 = new Bonus();
        addObject(bonus2,270,425);
        Bonus bonus3 = new Bonus();
        addObject(bonus3,620,344);
        Bonus bonus4 = new Bonus();
        addObject(bonus4,45,450);

        Enemy enemy = new Enemy();
        addObject(enemy,49,53);
        enemy.setInitialXY(49,53);

        Enemy enemy2 = new Enemy();
        addObject(enemy2,270,420);
        enemy2.setInitialXY(270,420);

        SecondEnemy secondEnemy = new SecondEnemy();
        addObject(secondEnemy,170,525);
        secondEnemy.setInitialXY(170,525);

        SecondEnemy secondEnemy2 = new SecondEnemy();
        addObject(secondEnemy2,725,150);
        secondEnemy2.setInitialXY(725,150);

        ThirdEnemy thirdEnemy = new ThirdEnemy();
        addObject(thirdEnemy,459,249);
        thirdEnemy.setInitialXY(459,249);

        ThirdEnemy thirdEnemy2 = new ThirdEnemy();
        addObject(thirdEnemy2,50,395);
        thirdEnemy2.setInitialXY(50,395);

        
        NextLevel nextLevel = new NextLevel();
        addObject(nextLevel,170,550);//{170, 550},
    }

    

}
