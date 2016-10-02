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
public class Food {
    private String name;
    private int calories;
    private int sugars;
    private int carbs;
    
    public Food(String name, int calories, int sugars, int carbs){
        this.name = name;
        this.calories = calories;
        this.sugars = sugars;
        this.carbs = carbs;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAmountOfCalories(int calories){
        this.calories = calories;
    }
    
    public int getAmountOfCalories(){
        return calories;
    }
    
    public void setAmountOfSugars(int sugar){
        this.sugars = sugar;
    }
    
    public int getAmountOfSugars(){
        return sugars;
    }
    
    public void setAmountOfCarbs(int carbs){
        this.carbs = carbs;
    }
    
    public int getAmountOfCarbs(){
        return carbs;
    }
}
