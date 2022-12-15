/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Area {
    public static Sector A;
    public static Sector B;
    public static Sector C;
    public static Sector D;

    public Area() {
        A = new Sector("Sector A", 3, Storage.triangle);
        B = new Sector("Sector B", 3, Storage.circle);
        C = new Sector("Sector C", 3, Storage.square);
        D = new Sector("Sector D", 3, Storage.star);
    }
}
