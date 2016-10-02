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
public class Lunch extends Food{
    private boolean isBrunch;

    public Lunch(String name, int calories, int sugars, int carbs, boolean isBrunch) {
        super(name, calories, sugars, carbs);
        this.isBrunch = isBrunch;
    }
    
    public void setIsBrunch(boolean isBrunch){
        this.isBrunch = isBrunch;
    }
    
    public boolean getIsBrunch(){
        return this.isBrunch;
    }
}
