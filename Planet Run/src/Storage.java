/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Storage {
    private static Resource food;
    private static Resource circle;
    private static Resource triangle;
    private static Resource square;
    private static Resource star;

    public Storage() {
        food = new Resource("Food", 2);
        circle = new Resource("Sand", 0);
        triangle = new Resource("Wood", 0);
        square = new Resource("Rock", 0);
        star = new Resource("Star", 0);
    }

    public static Resource getFood() {
        return food;
    }

    public static void setFood(Resource food) {
        Storage.food = food;
    }

    public static Resource getCircle() {
        return circle;
    }

    public static void setCircle(Resource circle) {
        Storage.circle = circle;
    }

    public static Resource getTriangle() {
        return triangle;
    }

    public static void setTriangle(Resource triangle) {
        Storage.triangle = triangle;
    }

    public static Resource getSquare() {
        return square;
    }

    public static void setSquare(Resource square) {
        Storage.square = square;
    }

    public static Resource getStar() {
        return star;
    }

    public static void setStar(Resource star) {
        Storage.star = star;
    }
    
    
    
}
