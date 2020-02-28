package com.company;

import java.util.Date;

public abstract class GeometricObject {
    private String color;
    private Boolean filled;
    private Date dateCreated;
    protected GeometricObject() {
        //protected: you can access from child class
        color = "red";
        filled = true;
        dateCreated = new Date();//today, at this time to create this GeoMetric Object
    }
    protected GeometricObject(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = new Date();//today, at this time to create this GeoMetric Object
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
}
