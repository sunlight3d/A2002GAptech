/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

/**
 Now we learn about "Abstract class"
 * What is "abstract" = "unfinished"
 */
public abstract class Shape { //Shape is an "unfinished" class = "abstract" class 
    //How to get area of a Shape ?
    //No, we don't have formula to calculate a shape's area 
    //we can't implement getArea() of Shape
    //so getArea() of Shape = unfinished = abstract
    //abstract method only contains name, NOT implemetation, NOT body
    public abstract Double getArea(); // who implement? Child Class will extends
    //do nothing
    //abstract method must be inside an "abstract class"
    private String color; //abstract class can contains "property"
    //It is different with interface
    //Can "Abstract class" contain "constructor" ?, YES, but not necessary
   public static final int aStaticVariable2 = 0;
   //You can define static variabe inside an "abstract class" YES
}
