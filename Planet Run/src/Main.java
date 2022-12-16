import java.util.*;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    
    public static int day;
    public static int score;
    public static Animal[] huntingGround;
    public static Animal[] animalDeck;
    
//    private Player player;

//    Resource food;
//    Resource triangle;
//    Resource circle;
//    Resource square;
//    Resource star;

//    Sector sectorA;
//    Sector sectorB;
//    Sector sectorC;
//    Sector sectorD;

    Gadget gun;
    Gadget axe;
    Gadget hammer;
    Gadget pick;
    Gadget hook;

    public Main() {
        day = 20;
        
        huntingGround = new Animal[2];
        animalDeck = new Animal[6];
        
//        player = new Player("");
        
//        food = new Resource("Food", 2);
//        triangle = new Resource("Triangle", 0);
//        circle = new Resource("Circle", 0);
//        square = new Resource("Square", 0);
//        star = new Resource("Star", 0);
        
//        sectorA = new Sector("Sector A", 3, Storage.triangle);
//        sectorB = new Sector("Sector B", 3, Storage.circle);
//        sectorC = new Sector("Sector C", 3, Storage.square);
//        sectorD = new Sector("Sector D", 3, Storage.star);
        
        

        gun = new Gadget("Gun", 7, Area.D, "+1 Energy When Hunting");
        axe = new Gadget("Axe", 7, Area.C, "+1 Energy When Gathering Triangle");
        hammer = new Gadget("Hammer", 7, Area.A, "+1 Energy When Gathering Circle");
        pick = new Gadget("Pick", 7, Area.B, "+1 Energy When Gathering Square");
        hook = new Gadget("Hook", 7, null, "83% to get 1 food");

        animalDeck[0] = new BirdKing();
        animalDeck[1] = new DoubleDog();
        animalDeck[2] = new Fourleg();
        animalDeck[3] = new Fishman();
        animalDeck[4] = new Snailbox();
        animalDeck[5] = new Rhinocow();
        
        while(Player.HP > 0){
            System.out.println("Day: "+day);
            // ========== UPKEEP ==========
            if (hook.isObtained() && Dice.rollAgainst(1, 2)){
                Storage.food.gain(1);
            }
            // ========== DRAW ==========
//            System.out.println(animalDeck);
            if (huntingGround.length < 2){
                int randomDraw = (int)(Math.random()*10)%(animalDeck.length-1);
                huntingGround[huntingGround.length - 1] = animalDeck[randomDraw];
                animalDeck[randomDraw] = null;
            }
            System.out.print("Hunting Ground: ");
//            for (int i=0;i<2;i++){
//                System.out.print(huntingGround[i].getName()+". ");
//            }
            System.out.println("");
            
            //while(player.getEnergy() > 0){
                // ========== ORDER ==========
                System.out.println("Choose your action");
                System.out.println("(0) Explore new sector");
                System.out.println("(1) Hunting");
                System.out.println("(2) Gather Resource");
                System.out.println("(3) Gadget Construction");
                System.out.println("(4) Rest");
                System.out.println("(5) Fix the Ship");
                
            //}
            // ========== EAT ==========
            int n = 1;
            Player.eat(n);
            Storage.food.consume(n);
            // ========== TURN END ==========
            Player.HP -= 1;
            dayPass();
        }

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public void dayPass(){
        day++;
    }
    
    public void shuffle(){
        
    }

    public void chooseAction(int action){
        System.out.println("How many energy?");
        int num = 1;
        while (num > Player.energy){
            System.out.println("energy not enough.");
            num--;
        }
        switch (action){
            case 0:
                //explore new sector
                System.out.println("Choose undiscovered sector.");
                break;
            case 1:
                //hunting
                break;
            case 2:
                //gather resource
                break;
            case 3:
                //gadget constrcution
                break;
            case 4:
                //rest
                break;
            case 5:
                //fix the ship
                break;
        }
    }
    
    public static void main(String[] args) {
        new Player("Christopher");
        new Storage();
        new Area();
        new Ship();
        day = 20;
        
        huntingGround = new Animal[2];
        animalDeck = new Animal[6];
        MainUI frame = new MainUI();
        // try {
        //     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //     } catch (Exception e) {
        //     e.printStackTrace();
        //     }
        //     SwingUtilities.invokeLater(() -> { MainUI frame = new MainUI(); });
         Thread n1 = new Thread(frame);
         n1.start();
    }
    
}
