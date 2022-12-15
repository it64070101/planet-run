/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class FinPart extends Part{

    public FinPart(String name) {
        super(name);
    }
    
    @Override
    public boolean check() {
        if (Storage.star.getAmount() >= 4){
            Storage.star.consume(4);
            return true;
        }
        else{
            return false;
        }
    }
    
}
