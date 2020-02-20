/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;

/**
 *
 * @author User
 */
public class Staff extends Person {
    private String school = "";
    private double pay;//primitive
    //private Double pay = 0.0;
    Staff() {}
    Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
   
    //setter
    public void setSchool(String school) {
        this.school = school;
    }
    public void setPay(double pay) {
        this.pay = pay;
    }
    //getter
    public String getSchool() {
        return this.school;
    }
    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", school : "+this.school+
                ", pay = "+this.pay;
    }
    
}
