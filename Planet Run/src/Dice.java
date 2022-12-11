/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

public class Dice {
    private static int face;

    public Dice() {
        this.face = 6;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }
    
    public static int roll(int amount){
        int sum = 0;
        for(int i=0;i<amount;i++){
            sum += ((Math.random()*10)%face)+1;
        }
        return sum;
    }
    
    public static boolean rollAgainst(int amount, int target){
        return roll(amount) >= target;
    }
}
