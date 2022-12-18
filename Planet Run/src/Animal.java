public abstract class Animal {
    private String name;
    private int rating;
    private int foodDrop;
    private int damage;
    private boolean isAlive;

    public Animal(String name, int rating, int foodDrop, int damage , boolean isAlive) {
        this.name = name;
        this.rating = rating;
        this.foodDrop = foodDrop;
        this.damage = damage;
        this.isAlive = true;
    }

    // getter setter no one cares
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getFoodDrop() {
        return foodDrop;
    }
    public void setFoodDrop(int foodDrop) {
        this.foodDrop = foodDrop;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean getIsAlive() {
        return isAlive;
    }
    public void setIsAlive(Boolean state) {
        this.isAlive = state;
    }
    
    public String getDifficulty(){
        switch (rating){
            case 4:
                return "(Easy+)";
            case 5:
                return "(Normal)";
            case 6:
                return "(Normal+)";
            case 7:
                return "(Hard)";
            case 8:
                return "(Hard+)";
            case 9:
                return "(Very Hard)";
            default:
                return "0";
        }
                
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", rating=" + rating + ", foodDrop=" + foodDrop + ", damage=" + damage + '}';
    }
    
    
}
