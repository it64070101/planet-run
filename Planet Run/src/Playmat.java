/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Playmat {
    private int day;
    private Animal huntingGround[];
    private int score;
    
    public Playmat() {
        this.day = 0;
        this.score = 0;
    }
    
    public void dayPass(){
        setDay(getDay()+1);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Animal[] getHuntingGround() {
        return huntingGround;
    }

    public void setHuntingGround(Animal[] huntingGround) {
        this.huntingGround = huntingGround;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
