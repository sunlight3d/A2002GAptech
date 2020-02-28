/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aptech;
import java.util.Date;

public abstract class GeometricObject {
    private String name;
    private String color;
    private Boolean filled;
    private final Date dateCreated;
    protected GeometricObject() {
        //protected: you can access from child class
        color = "red";
        filled = true;
        dateCreated = new Date();//today, at this time to create this GeoMetric Object
    }
    protected GeometricObject(String name, String color, Boolean filled) {
        //**
        this.name = name;
        this.color = color;
        this.filled = filled;
        this.dateCreated = new Date();//today, at this time to create this GeoMetric Object
    }
    
    protected GeometricObject(String color, Boolean filled) {
        //**
        this.color = color;
        this.filled = filled;
        this.dateCreated = new Date();//today, at this time to create this GeoMetric Object
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    //toString return to detail object
    public String toString() {
        return "Name : "+this.name+
                ",color : "+this.color+
        ", filled : "+(this.filled ? "Yes" : "No") + 
        ", createdDate : "+this.dateCreated+"\n";
    }
    //abstract methods = "no implementation", child must override
    public abstract Double getArea();
    public abstract Double getPerimeter();
}