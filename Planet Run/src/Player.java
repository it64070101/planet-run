public class Player {
    private int HP;
    private int energy;
    private int food;

    public Player() {
        HP = 4;
        energy = 3;
        food = 2;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
    
    public void eat(int food){
        switch (food) {
            case 0:
                setEnergy(2);
                setHP(getHP()-1);
                break;
            case 1:
                setEnergy(2);
                break;
            case 2:
                setEnergy(3);
                break;
            case 4:
                setEnergy(4);
                break;
            case 6:
                setEnergy(6);
                break;
            default:
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
    }
    
    public void fix(Part part){
        
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
    
    public void rest(int energy){
        setEnergy(getEnergy()-energy);
        setHP(getHP()+energy);
    }

    @Override
    public String toString() {
        return "Player:" + " HP: " + HP + ", Energy: " + energy;
    }
    
    
    
}
