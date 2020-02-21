/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;

import java.util.ArrayList;

public class Person implements IPlayable{
    //class Person implements IPlayable 
    //= "class Person must do/implement all methods/functions in IPlayable"
    private String name, address;
    private String firstName, lastName;
    
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
                
    }
    public String getFullName(){
        return firstName + " "+ lastName;
    }
    //public void setFullName => NO !
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //setter 
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    //getter
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    @Override //override from Object
    public String toString() {
        return "Name: "+this.name+
                ",Address : "+this.address;
    }
    
    //construtor
    //default constructor
    Person() {
        this.name = "";
        this.address = "";
    }
    Person(String name) {
        this.name = name;
        this.address = "";
    }
    //...overloading
    /*
    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    */
    //Here are some methods that relating to "playing"
    @Override
    public void playFootball(String address) {
        System.out.println("I am playing football at "+address);
    }
    @Override
    public void playTennis() {
        System.out.println("I am playing tennis");
    }
    //...
    //Here are some methods that relating to "learning"
    public void gotoLibrary(String libraryName) {
        System.out.println("I am going to library: "+libraryName);
    }
    public void borrowSomeBooks(ArrayList<String> bookNames) {
        System.out.println("I am borroring books:"+bookNames.toString());
    }
    
}
