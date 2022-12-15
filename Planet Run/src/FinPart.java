/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class FinPart extends Part{

    @Override
    public boolean check() {
        return (Storage.star.getAmount() >= 4);
    }
    
}
