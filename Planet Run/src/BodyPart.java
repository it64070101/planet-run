/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class BodyPart extends Part{

    public BodyPart(String name) {
        super(name);
    }
    
    @Override
    public boolean check() {
        if (Storage.triangle.getAmount() >= 1 && Storage.circle.getAmount() >= 1 && Storage.square.getAmount() >= 1){
            Storage.triangle.consume(1);
            Storage.circle.consume(1);
            Storage.square.consume(1);
            return true;
        }
        else{
            return false;
        }
    }
    
}
