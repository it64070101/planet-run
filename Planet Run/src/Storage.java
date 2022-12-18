/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Storage {
    public static Resource food;
    public static Resource circle;
    public static Resource triangle;
    public static Resource square;
    public static Resource star;

    public Storage() {
        food = new Resource("Food", 2);
        circle = new Resource("Sand", 0);
        triangle = new Resource("Wood", 0);
        square = new Resource("Rock", 0);
        star = new Resource("Star", 0);
    }
    
}
