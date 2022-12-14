public abstract class Animal {
    private String name;
    private int rating;
    private int foodDrop;
    private int damage;

    public Animal(String name, int rating, int foodDrop, int damage) {
        this.name = name;
        this.rating = rating;
        this.foodDrop = foodDrop;
        this.damage = damage;
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

    public void isAttacked(int playerAttack, Player player) {
        if(playerAttack >= getRating()){
            player.setFood(player.getFood() + getFoodDrop());
        }else{
            player.setHP(player.getHP() - getDamage());
        }
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", rating=" + rating + ", foodDrop=" + foodDrop + ", damage=" + damage + '}';
    }
    
    
}
