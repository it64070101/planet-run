public class Resource {
    private String name;
    private int amount;

    public Resource(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void consume(int amount) {
        this.amount -= amount;
    }
    
    public void gain(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "Resource{" + "name=" + name + ", amount=" + amount + '}';
    }
    
    
    
    
}
