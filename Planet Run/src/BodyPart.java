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
        if (Storage.getTriangle().getAmount() >= 1 && Storage.getCircle().getAmount() >= 1 && Storage.getSquare().getAmount() >= 1){
            Storage.getTriangle().consume(1);
            Storage.getCircle().consume(1);
            Storage.getSquare().consume(1);
            return true;
        }
        else{
            return false;
        }
    }
    
}
