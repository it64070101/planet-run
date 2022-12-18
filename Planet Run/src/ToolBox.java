/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ToolBox {
    public static Gadget gun;
    public static Gadget axe;
    public static Gadget hammer;
    public static Gadget pick;
    public static Gadget hook;
    public static int toolMade;

    public ToolBox() {
        toolMade = 0;
        gun = new Gadget("Gun", 7, Area.sectorMap.get("Altar"), "Bonus when hunting");
        axe = new Gadget("Axe", 7, Area.sectorMap.get("Mountain"), "Bonus when gathering wood");
        hammer = new Gadget("Hammer", 7, Area.sectorMap.get("Forest"), "Bonus when gathering sand");
        pick = new Gadget("Pick", 7, Area.sectorMap.get("Desert"), "Bonus when gathering rock");
        hook = new Gadget("Hook", 7, null, "Chane to get 1 food everyday");
    }
    
}
