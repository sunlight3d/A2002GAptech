/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;
//public = access everywhere in your project
//private = access only inside class

import java.lang.reflect.Array;
import java.util.ArrayList;

//default = access inside a package
//protected = only in child class, and package ?
public class Table {
    private Double width, height;
    
    public Table(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getArea(int numberOfDigit) {
        Double result = Double.valueOf(String.format("%."+numberOfDigit+"f", 
                this.width * this.height));           
        return result;
    }
    public static Double randomAFloat(Double min, Double max) {
        //Refactor "Extract"
        return min + Math.random() * (max - min);
    }

    @Override //return a string of "detail object"
    public String toString() {
        return "Width : "+Table.formatADouble(width, 2)+"\n"+
                "Height : "+Table.formatADouble(height, 2)+"\n";
    }
    public static Double formatADouble(Double aDoubleValue, int numberOfDigit) {
        Double result = Double.valueOf(String.format("%."+numberOfDigit+"f", aDoubleValue));           
        return result;
    }
    
}
