
import java.util.*;
import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static int day;
    public static int score;
    public static Animal[] huntingGround;
    public static Animal[] animalDeck;

    public Main() {
        day = 0;

        huntingGround = new Animal[2];
        animalDeck = new Animal[6];



        animalDeck[0] = new BirdKing();
        animalDeck[1] = new DoubleDog();
        animalDeck[2] = new Fourleg();
        animalDeck[3] = new Fishman();
        animalDeck[4] = new Snailbox();
        animalDeck[5] = new Rhinocow();

        while (Player.HP > 0) {
//            System.out.println("Day: " + day);
            JOptionPane.showMessageDialog(null, "Day "+ day);
//            if (hook.isObtained() && Dice.rollAgainst(1, 2)) {
//                JOptionPane.showMessageDialog(null, "You gain 1 food from hook.");
//                Storage.food.gain(1);
//            }
            // ========== DRAW ==========
//            if (huntingGround.length < 2) {
//                int randomDraw = (int) (Math.random() * 10) % (animalDeck.length - 1);
//                huntingGround[huntingGround.length - 1] = animalDeck[randomDraw];
//                animalDeck[randomDraw] = null;
//            }
//            System.out.print("Hunting Ground: ");
//            for (int i=0;i<2;i++){
//                System.out.print(huntingGround[i].getName()+". ");
//            }

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

    public void dayPass() {
        day++;
    }

    public void shuffle() {

    }

    public void chooseAction(int action) {
        System.out.println("How many energy?");
        int num = 1;
        while (num > Player.energy) {
            System.out.println("energy not enough.");
            num--;
        }
        switch (action) {
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
        new Dice(6);
        new Player("Christopher");
        new Storage();
        new Area();
        new Ship();
        new ToolBox();
        day = 0;

        huntingGround = new Animal[2];
        animalDeck = new Animal[6];
        MainUI frame = new MainUI();
        Thread n1 = new Thread(frame);
        n1.start();
    }

}
