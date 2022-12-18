/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ToolBox {
    private static Gadget gun;
    private static Gadget axe;
    private static Gadget hammer;
    private static Gadget pick;
    private static Gadget hook;
    private static int toolMade;

    public ToolBox() {
        toolMade = 0;
        gun = new Gadget("Gun", 7, Area.getSectorMap().get("Altar"), "Bonus when hunting");
        axe = new Gadget("Axe", 7, Area.getSectorMap().get("Mountain"), "Bonus when gathering wood");
        hammer = new Gadget("Hammer", 7, Area.getSectorMap().get("Forest"), "Bonus when gathering sand");
        pick = new Gadget("Pick", 7, Area.getSectorMap().get("Desert"), "Bonus when gathering rock");
        hook = new Gadget("Hook", 7, null, "Chane to get 1 food everyday");
    }

    public static Gadget getGun() {
        return gun;
    }

    public static void setGun(Gadget gun) {
        ToolBox.gun = gun;
    }

    public static Gadget getAxe() {
        return axe;
    }

    public static void setAxe(Gadget axe) {
        ToolBox.axe = axe;
    }

    public static Gadget getHammer() {
        return hammer;
    }

    public static void setHammer(Gadget hammer) {
        ToolBox.hammer = hammer;
    }

    public static Gadget getPick() {
        return pick;
    }

    public static void setPick(Gadget pick) {
        ToolBox.pick = pick;
    }

    public static Gadget getHook() {
        return hook;
    }

    public static void setHook(Gadget hook) {
        ToolBox.hook = hook;
    }

    public static int getToolMade() {
        return toolMade;
    }

    public static void setToolMade(int toolMade) {
        ToolBox.toolMade = toolMade;
    }
    
    public static void countTool(){
        setToolMade(getToolMade()+1);
    }
    
}
