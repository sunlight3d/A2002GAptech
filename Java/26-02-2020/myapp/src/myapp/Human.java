/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

public abstract class Human {
    private String skinColor;
    public abstract void work();//ABSTRACT also MEAN "child object MUST override "

    public String getSkinColor() {
        return skinColor;
    }

    //non-abstract = "child object" NOT NECESSARY to override 
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }
    
}
