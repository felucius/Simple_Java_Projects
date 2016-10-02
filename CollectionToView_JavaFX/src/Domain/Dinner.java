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
public class Dinner extends Food{
    private boolean isHot;

    public Dinner(String name, int calories, int sugars, int carbs, boolean isHot) {
        super(name, calories, sugars, carbs);
        this.isHot = isHot;
    }
    
    public void setIsHot(boolean isHot){
        this.isHot = isHot;
    }
    
    public boolean getIsHot(){
        return isHot;
    }
}
