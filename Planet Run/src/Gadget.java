/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Gadget {
    private String name;
    private int targetNumber;
    private Sector sectorRequirement;
    private boolean obtained;
    private final String ability;

    public Gadget(String name, int targetNumber, Sector sectorRequirement, String ability) {
        this.name = name;
        this.targetNumber = targetNumber;
        this.sectorRequirement = sectorRequirement;
        this.obtained = false;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public Sector getSectorRequirement() {
        return sectorRequirement;
    }

    public void setSectorRequirement(Sector sectorRequirement) {
        this.sectorRequirement = sectorRequirement;
    }

    public boolean isObtained() {
        return obtained;
    }

    public void setObtained(boolean obtained) {
        this.obtained = obtained;
    }

    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return name + ", Target Number: " + targetNumber + ", Sector: " + sectorRequirement + ", Obtained: " + obtained + ", Ability: " + ability;
    }
    
    
    
}
