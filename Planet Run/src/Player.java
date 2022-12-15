public class Player {
    public static int HP;
    public static int energy;
    public static String name;


    public Player(String name) {
        Player.name = name;
        HP = 4;
        energy = 3;
    }
    
    public static void eat(int food){
        switch (food) {
            case 0 -> {
                energy = 2;
                HP--;
            }
            case 1 -> energy = 2;
            case 2 -> energy = 3;
            case 4 -> energy = 4;
            case 6 -> energy = 6;
            default -> {
            }
        }
    }
    
    public void gather(Sector sector, int amount){
        if (Dice.rollAgainst(amount, sector.getPip())){
            sector.getResource().gain(1);
            System.out.println("Success, gain "+sector.getResource().getName()+".");
        }
        else{
            System.out.println("Fail to gather resource from"+sector.getName()+".");
        }
    }
    
    public void explore(Sector sector, int amount){
        if (Dice.rollAgainst(amount, 4)){
            sector.setExplored(true);
            System.out.println("Success, discover "+sector.getName()+".");
        }
        else{
            System.out.println("Fail to explore.");
        }
        Player.energy -= amount;
    }
    
    public static boolean fix(Part part){
        if (part.check()){
            System.out.println("Fix "+part.getName()+" Successful.");
            Player.energy--;
            return true;
        }
        else{
            System.out.println("Can't Fix "+part.getName());
            return false;
        }
    }
    
    public void hunting(Animal animal){
        
    }
    
    public void construction(Gadget gadget, int amount){
        if (Dice.rollAgainst(amount, gadget.getTargetNumber())){
            gadget.setObtained(true);
            System.out.println("Success, complete "+gadget.getName()+".");
        }
        else{
            System.out.println("Fail to construct.");
        }
        
    }
    
    public static void rest(int energy){
        Player.energy -= energy;
        Player.HP += energy;
    }
    
    @Override
    public String toString() {
        return "Player:" + " HP: " + HP + ", Energy: " + energy;
    }
    
    
    
}
