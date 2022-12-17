import javax.swing.*;

public class Player {
    public static int HP;
    public static int energy;
    public static String name;
    public static int selectedEnergy;


    public Player(String name) {
        Player.name = name;
        HP = 4;
        energy = 3;
        selectedEnergy = 0;
    }
    
    public static void eat(int food){
        switch (food) {
            case 0 -> {
                energy = 2;
                HP--;
            }
            case 1 -> energy = 2;
            case 2 -> energy = 3;
            case 3 -> energy = 4; 
            case 4 -> energy = 5;
            case 5 -> energy = 6;
            default -> {
            }
        }
        if (food == 0){
            JOptionPane.showMessageDialog(null, "You not eat. gain "+energy+" and -1 HP");
        }
        else{
            Storage.food.consume(food);
            JOptionPane.showMessageDialog(null, "You eat "+food+" food to gain "+energy+" energy");
        }
    }
    
    public static void gather(Sector sector, int amount){
        if (Dice.rollAgainst(amount, sector.getPip())){
            sector.getResource().gain(1);
            JOptionPane.showMessageDialog(null, "Success to gathering. Gain 1 "+sector.getResource().getName()+".");
        }
        else{
            JOptionPane.showMessageDialog(null, "Fail to gathering resource from "+sector.getName()+".");
        }
        Player.energy -= amount;
    }
    
    public static void explore(Sector sector, int amount){
        if (Dice.rollAgainst(amount, 4)){
            sector.setExplored(true);
            JOptionPane.showMessageDialog(null, "Success to explore. Discover "+sector.getName()+".");
        }
        else{
            JOptionPane.showMessageDialog(null, "Fail to explore this sector.");
        }
        Player.energy -= amount;
    }
    
    public static boolean fix(Part part){
        if (part.check()){
//            System.out.println("Fix "+part.getName()+" Successful.");
            Player.energy--;
            JOptionPane.showMessageDialog(null, "Success to fix "+part.getName()+".");
            return true;
        }
        else{
//            System.out.println("Can't Fix "+part.getName());
            JOptionPane.showMessageDialog(null, "Resource not enough to fix "+part.getName()+".");
            return false;
        }
    }
    
    public static void hunting(Animal animal, int amount){
        if (Dice.rollAgainst(amount*10, animal.getRating())){
            JOptionPane.showMessageDialog(null, "Hunting succeeded. You got "+animal.getFoodDrop()+" foods!.");
            animal.setIsAlive(false);
            Storage.food.gain(animal.getFoodDrop());
        }
        else{
            JOptionPane.showMessageDialog(null, "Hunting failed. You took "+animal.getDamage()+" damages!.");
            Player.HP = Player.HP - animal.getDamage();
        }
        Player.energy -= amount;

        // if(playerAttack >= getRating()){
        //     Storage.food.gain(getFoodDrop());
        // }else{
        //     Player.HP = Player.HP - getDamage();
        // }
    }
    
    public static boolean construction(Gadget gadget, int amount){
        if (Dice.rollAgainst(amount, gadget.getTargetNumber())){
            gadget.setObtained(true);
            System.out.println("Success, complete "+gadget.getName()+".");
            JOptionPane.showMessageDialog(null, "Success to make "+gadget.getName()+".");
            gadget.setObtained(true);
            Player.energy -= amount;
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Fail to make "+gadget.getName()+".");
            Player.energy -= amount;
            return false;
        }
        
    }
    
    public static void rest(int energy){
        Player.energy -= energy;
        Player.HP += energy;
//        System.out.println("You are rested");
        JOptionPane.showMessageDialog(null, "You are rested ( HP +"+energy+" ).");
    }
    
    @Override
    public String toString() {
        return "Player:" + " HP: " + HP + ", Energy: " + energy;
    }
    
    
    
}
