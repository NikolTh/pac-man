import greenfoot.*;  

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends MyWorlds
{
    public Text introText;
    private GreenfootSound backgroundMusic;
    
    //private boolean isPaused = false; // Μεταβλητή για τον έλεγχο της παύσης
    
    /**
     * Constructor for objects of class Intro.
     * 
     */
    public Intro()
    {    
        super();
        prepare();
        backgroundMusic = new GreenfootSound("intro.mp3");
        
    }

    public void started()
    {
        backgroundMusic.play(); 
    }
    
    public void stopped()
    {
        backgroundMusic.stop();
    }

    public void act(){
        String keyPressed = Greenfoot.getKey();

        if(keyPressed != null){
            if(keyPressed.equals("enter")){
                backgroundMusic.stop();  
                Greenfoot.setWorld(new FirstWorld());        
            }
        }
        
        
        prepare();
    }

    public void prepare(){

        Decoration logo = new Decoration("logo.png",300,100);
        addObject(logo,400,100);
        
        Text purpose = new Text("Σκοπός του παιχνιδιού είναι να μαζέψετε όλα τα dots από κάθε πίστα\n και να συγκεντρώσετε τους περισσότερους πόντους αποφεύγοντας τους εχθρούς.");
        addObject (purpose, 35, 180);
        
        Text introText = new Text("Παίκτης:");
        addObject (introText, 170, 270);
        Decoration player = new Decoration("Pacman2.png",32,32);
        addObject(player,310,260);
        
        Text introText2 = new Text("Μετακινηθείτε με:");
        addObject (introText2, 85, 345);// 270);
        Decoration movement = new Decoration("keyboard.png",80,50);
        addObject(movement,310,335);// 260);
        
        Text introText3 = new Text("Επόμενο επίπεδο:");
        addObject (introText3, 63, 415);//500, 345);
        Decoration level = new Decoration("nextlevel1.png",32,32);
        addObject(level,310,415);
        
        Text introText4 = new Text("Τέλος:");
        addObject (introText4, 180, 485);
        Decoration end = new Decoration("final3.png",32,32);
        addObject(end,310,485);//700,415);
        
        Text introText5 = new Text("Συλλέξτε +10points:");
        addObject (introText5, 445, 415);
        Decoration dot = new Decoration("yellow-dot.png",32,32);
        addObject(dot,660,415);
        
  
        Text introText6 = new Text("Bonus +20points:");
        addObject (introText6, 460, 485);
        Decoration bonus = new Decoration("cherries.png",32,32);
        addObject(bonus,660,485);
        
        Text introText7 = new Text("Πατήστε Enter για να ξεκινήσετε");
        addObject (introText7, 250, 570);
        
        Text introText8 = new Text("Κερδίζετε +1 extra ζωή:");
        addObject (introText8, 408, 345);
        Decoration life = new Decoration("herz.png",30,30);
        addObject(life,660,345);
        
        Text introText9 = new Text("Εχθροί (-1 ζωή):");
        addObject (introText9, 440, 270);
        Decoration enemy = new Decoration("Enemy2.png",32,32);
        addObject(enemy,620,270);
        Decoration enemy2 = new Decoration("SecondEnemy2.png",32,32);
        addObject(enemy2,660,270);
        Decoration enemy3 = new Decoration("ThirdEnemy2.png",32,32);
        addObject(enemy3,700,270);
        Decoration enemy4 = new Decoration("FourthEnemy5.png",32,32);
        addObject(enemy4,740,270);
        /*
         Text introText9 = new Text("Εχθροί\n(-1 ζωή):");
        addObject (introText9, 520, 498);
        Decoration enemy = new Decoration("Enemy2.png",32,32);
        addObject(enemy,640,485);
        Decoration enemy2 = new Decoration("SecondEnemy2.png",32,32);
        addObject(enemy2,680,485);
        Decoration enemy3 = new Decoration("ThirdEnemy2.png",32,32);
        addObject(enemy3,640,525);
        Decoration enemy4 = new Decoration("FourthEnemy5.png",32,32);
        addObject(enemy4,680,525);
         */
        
        
        //Decoration note = new Decoration("note.png",200,300);
        //addObject(note,600,380);
        
    }
}
    
    
