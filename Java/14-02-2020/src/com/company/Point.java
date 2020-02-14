package com.company;

public class Point {
    private Float x;
    private Float y;
    private String color;
    Point(Float x, Float y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    //getter = make your property readable, "read-only"
    public Float getX(){
        return this.x;
    }
    //setter = a method to assign value of a property
    //setter + getter => the property becomes "read-write"
    //if have only getter => property is "read-only"
    //if have only setter => property is "write-only"
    //if we have no setter + no getter => property is "hidden"
    public void setX(Float x){
        this.x = x;
    }
    //methods ?
    public Float distanceFromO() {

        //sqrt = squared root
        return (float)Math.sqrt((float)Math.pow(this.x, 2) + (float) Math.pow(this.y, 2));
    }
}
