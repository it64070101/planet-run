public class Sector {
    private String name;
    private int pip;
    private Resource resource;
    private boolean explored;

    public Sector(String name, int pip, Resource resource) {
        this.name = name;
        this.pip = pip;
        this.resource = resource;
        this.explored = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPip() {
        return pip;
    }

    public void setPip(int pip) {
        this.pip = pip;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }
    
    
    
}
