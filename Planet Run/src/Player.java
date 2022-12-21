import javax.swing.*;

public class Player {
    private static int HP;
    private static int energy;
    private static String name;
    private static int animalKilled;


    public Player(String name) {
        Player.name = name;
        HP = 4;
        energy = 3;
        animalKilled = 0;
    }
    
    public static void eat(int food){
        switch (food) {
            case 0 -> {
                setEnergy(2);
                harm(1);
            }
            case 1 -> setEnergy(2);
            case 2 -> setEnergy(3);
            case 3 -> setEnergy(4);
            case 4 -> setEnergy(5);
            case 5 -> setEnergy(6);
            default -> {
            }
        }
        if (food == 0){
            JOptionPane.showMessageDialog(null, "You not eat. gain "+getEnergy()+" and -1 HP","Hungry",JOptionPane.ERROR_MESSAGE);
        }
        else{
            Storage.getFood().consume(food);
            JOptionPane.showMessageDialog(null, "You eat "+food+" food to gain "+getEnergy()+" energy","Yummy!",JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public static void gather(Sector sector, int amount){
        Gadget gadget = null;
        switch (sector.getName()) {
            case "Forest":
                gadget = ToolBox.getAxe();
                break;
            case "Mountain":
                gadget = ToolBox.getPick();
                break;
            case "Desert":
                gadget = ToolBox.getHammer();
                break;
            default:
                gadget = null;
                break;
        }
        if (Dice.rollAgainst(amount+gadgetBonus(gadget), sector.getPip())){
            sector.getResource().gain(1);
            JOptionPane.showMessageDialog(null, "Success to gathering. Gain 1 "+sector.getResource().getName()+".","",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Fail to gathering resource from "+sector.getName()+".","",JOptionPane.ERROR_MESSAGE);
        }
        useEnergy(amount);
    }
    
    public static void explore(Sector sector, int amount){
        
        
        if (Dice.rollAgainst(amount, 4)){
            sector.setExplored(true);
            JOptionPane.showMessageDialog(null, "Success to explore. Discover "+sector.getName()+".","",JOptionPane.PLAIN_MESSAGE);
            Area.countExplore();
        }
        else{
            JOptionPane.showMessageDialog(null, "Fail to explore this sector.","",JOptionPane.ERROR_MESSAGE);
        }
        useEnergy(amount);
    }
    
    public static boolean fix(Part part){
        if (part.check()){
            useEnergy(1);
            JOptionPane.showMessageDialog(null, "Success to fix "+part.getName()+".","",JOptionPane.PLAIN_MESSAGE);
            Ship.countFixed();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Resource not enough to fix "+part.getName()+".","",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static void hunt(Animal animal, int amount){
        if (Dice.rollAgainst(amount+gadgetBonus(ToolBox.getGun()), animal.getRating())){
            JOptionPane.showMessageDialog(null, "Hunting succeeded. You got "+animal.getFoodDrop()+" foods!.","",JOptionPane.PLAIN_MESSAGE);
            animal.setIsAlive(false);
            Storage.getFood().gain(animal.getFoodDrop());
            animalKilled++;
        }
        else{
            JOptionPane.showMessageDialog(null, "Hunting failed. You took "+animal.getDamage()+" damages!.","",JOptionPane.ERROR_MESSAGE);
            harm(animal.getDamage());
        }
        useEnergy(amount);

    }
    
    public static boolean craft(Gadget gadget, int amount){
        if (Dice.rollAgainst(amount, gadget.getTargetNumber())){
            gadget.setObtained(true);
            System.out.println("Success, complete "+gadget.getName()+".");
            JOptionPane.showMessageDialog(null, "Success to make "+gadget.getName()+".","",JOptionPane.PLAIN_MESSAGE);
            gadget.setObtained(true);
            useEnergy(amount);
            ToolBox.countTool();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Fail to make "+gadget.getName()+".","",JOptionPane.ERROR_MESSAGE);
            useEnergy(amount);
            return false;
        }
        
    }
    
    public static void rest(int energy){
        useEnergy(energy);
        JOptionPane.showMessageDialog(null, "You are rested ( HP +"+energy+" ).","Soundly Slept",JOptionPane.PLAIN_MESSAGE);
        heal(energy);
    }
    
    public static int gadgetBonus(Gadget gadget){
        if (gadget == null){
            return 0;
        }
        if (gadget.isObtained()){
            JOptionPane.showMessageDialog(null, "You have +1 engergy with "+gadget.getName()+" !","Bonus from "+gadget.getName(),JOptionPane.PLAIN_MESSAGE);
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public static void heal(int amount){
        setHP(getHP()+amount);
    }
    
    public static void harm(int amount){
        setHP(getHP()-amount);
    }

    public static int getHP() {
        return HP;
    }

    public static void setHP(int HP) {
        Player.HP = HP;
    }

    public static int getEnergy() {
        return energy;
    }

    public static void setEnergy(int energy) {
        Player.energy = energy;
    }
    
    public static void useEnergy(int amount){
        setEnergy(getEnergy()-amount);
    }
    
    public static void chargeEnergy(int amount){
        setEnergy(getEnergy()+amount);
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static int getAnimalKilled() {
        return animalKilled;
    }

    public static void setAnimalKilled(int animalKilled) {
        Player.animalKilled = animalKilled;
    }
    
    public static void countKilled(){
        setAnimalKilled(getAnimalKilled()+1);
    }
    
}
