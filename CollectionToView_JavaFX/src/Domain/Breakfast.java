/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Maxime de Lange
 */
public class Breakfast extends Food{
    private boolean ateBreakfast;

    public Breakfast(String name, int calories, int sugars, int carbs, boolean ateBreakfast) {
        super(name, calories, sugars, carbs);
        this.ateBreakfast = ateBreakfast;
    }
    
    public void setAteBreakfast(boolean ateBreakfast){
        this.ateBreakfast = ateBreakfast;
    }
    
    public boolean getAteBreakfast(){
        return ateBreakfast;
    }
}
