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
        food = new Resource("food", 2);
        circle = new Resource("circle", 0);
        triangle = new Resource("triangle", 0);
        square = new Resource("square", 0);
        star = new Resource("star", 8);
    }
    
}
