/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class BodyPart extends Part{

    @Override
    public boolean check() {
        return (Storage.triangle.getAmount() >= 1 && Storage.circle.getAmount() >= 1 && Storage.square.getAmount() >= 1);
    }
    
}
