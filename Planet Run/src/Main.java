public class Main {
    
    private int day;
    private int score;
    private Animal[] huntingGround;
    private Animal[] animalDeck;
    
    private Player player;

    Resource food;
    Resource triangle;
    Resource circle;
    Resource square;
    Resource star;

    Sector sectorA;
    Sector sectorB;
    Sector sectorC;
    Sector sectorD;

    Gadget gun;
    Gadget axe;
    Gadget hammer;
    Gadget pick;
    Gadget hook;

    public Main(String[] args) {
        day = 0;
        
        huntingGround = new Animal[2];
        animalDeck = new Animal[6];
        
        player = new Player();
        
        food = new Resource("Food", 2);
        triangle = new Resource("Triangle", 0);
        circle = new Resource("Circle", 0);
        square = new Resource("Square", 0);
        star = new Resource("Star", 0);
        
        sectorA = new Sector("Sector A", 3, triangle);
        sectorB = new Sector("Sector B", 3, circle);
        sectorC = new Sector("Sector C", 3, square);
        sectorD = new Sector("Sector D", 3, star);

        gun = new Gadget("Gun", 7, sectorD, "+1 Energy When Hunting");
        axe = new Gadget("Axe", 7, sectorC, "+1 Energy When Gathering Triangle");
        hammer = new Gadget("Hammer", 7, sectorA, "+1 Energy When Gathering Circle");
        pick = new Gadget("Pick", 7, sectorB, "+1 Energy When Gathering Square");
        hook = new Gadget("Hook", 7, null, "83% to get 1 food");

        animalDeck[0] = new BirdKing();
        animalDeck[1] = new DoubleDog();
        animalDeck[2] = new Fourleg();
        animalDeck[3] = new Fishman();
        animalDeck[4] = new Snailbox();
        animalDeck[5] = new Rhinocow();
        
        System.out.println(day);
        
        while(player.getHP() > 0){
            System.out.println(player);
            System.out.println("Day: "+day);
            // ========== UPKEEP ==========
            if (hook.isObtained() && Dice.rollAgainst(1, 2)){
                food.gain(1);
            }
            // ========== DRAW ==========
            System.out.println(animalDeck);
            if (huntingGround.length < 2){
                int randomDraw = (int)(Math.random()*10)%(animalDeck.length-1);
                huntingGround[huntingGround.length - 1] = animalDeck[randomDraw];
                animalDeck[randomDraw] = null;
            }
            System.out.print("Hunting Ground: ");
            for (int i=0;i<2;i++){
                System.out.print(huntingGround[i].getName()+". ");
            }
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
            player.eat(n);
            food.consume(n);
            // ========== TURN END ==========
            player.setHP(player.getHP()-1);
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

    public void explore(int num){

    }
    
}
