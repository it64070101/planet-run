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
        gun = new Gadget("Gun", 7, Area.D, "+1 Energy When Hunting");
        axe = new Gadget("Axe", 7, Area.C, "+1 Energy When Gathering Triangle");
        hammer = new Gadget("Hammer", 7, Area.A, "+1 Energy When Gathering Circle");
        pick = new Gadget("Pick", 7, Area.B, "+1 Energy When Gathering Square");
        hook = new Gadget("Hook", 7, null, "83% to get 1 food");
    }
    
}
