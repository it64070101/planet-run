public abstract class Part {
    private String name;
    private boolean fixed;

    public Part(String name) {
        this.name = name;
        fixed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
    
    
//    private Resource requirement;
    public abstract boolean check();
    
}
