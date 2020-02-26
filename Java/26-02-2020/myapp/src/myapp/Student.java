/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;
public class Student extends Human{
    private String schoolName;
    @Override
    public void work() {
        System.out.println("Student is working");
    }

    Student(String skinColor, String schoolName) {
        super.setSkinColor(skinColor); //super = "object of Shape"
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "skin color : "+this.getSkinColor()+"\n"+
                "school's name : "+this.schoolName;
    }
    
    
}
