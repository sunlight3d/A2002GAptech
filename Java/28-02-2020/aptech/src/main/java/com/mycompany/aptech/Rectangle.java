/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aptech;

/**
 *
 * @author User
 */
public class Rectangle extends GeometricObject implements Cloneable{
    //Compile doesnot require you implement anything ?
    //Because inside Cloneable is blank !
    //Rectable implements Cloneable MEANS : "Retangle can be clone"
    private double width, height;
    
    @Override
    public Double getArea() {
        return width * height;
    }

    @Override
    public Double getPerimeter() {
        return 2*(width + height);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(String name, double width, double height, String color, Boolean filled) {
        super(name, color, filled);
        this.width = width;
        this.height = height;
    }
    
    
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + 
                "width: "+ this.width+
                ", height: "+ this.height;
    }        
    //So make a public clone allows GeometricManager to call
    public Rectangle clone() {
        try {
            //BUT super.clone() is "protected" => GeometricManager cannot call it
            return (Rectangle)super.clone(); 
        }catch(CloneNotSupportedException exception) {
            return null; //CAnnco clone
        }       
    }
    
}
