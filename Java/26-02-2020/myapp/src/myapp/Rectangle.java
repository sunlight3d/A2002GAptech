/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

/**
 *
 * @author User
 */
//CAN A class extends ONE Class AND implements MANY interface ? YES
public class Rectangle extends Shape implements IPlayabe {
    //A child class can ONLY extends ONE asbtract class
//Rectangle MUST implements/extends/override Shape's ABSTRACT methods
    private Double width, height;
    @Override
    public Double getArea() {
        return width * height;
    }

    @Override
    public void playFootball() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
