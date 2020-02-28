/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aptech;
public class Circle extends GeometricObject {
    private double radius;
    @Override
    public Double getArea() {
        return Math.PI * radius * radius ;
    }

    @Override
    public Double getPerimeter() {
        return Math.PI * radius * 2.0 ;
    }        
    //some constructors
    Circle(double radius) {
        this.radius = radius;
    }
    Circle(double radius, String color, Boolean filled) {
        //this.color = color; //NO, let's call the parent's constructor
        super(color, filled);//**
        this.radius = radius;        
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
}
