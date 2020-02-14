package com.company;

public class Student {
    //properties = attributes
    private String name; //private = cannot access outside class
    private Integer age;
    private String email;
    //constructor with parameters
    Student(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    //a student can: "go to school", "go to work", ....
    public void gotoSchool() {
        //it is a function = method
        //Inside a class/method, you can access "private properties
        System.out.println(this.name+" is going to school");
    }
    public void gotoWork() {
        //it is a function = method
        System.out.println(this.name + " is going to work");
    }
    //constructor = function which is called when creating an object
    //constructor's name = class' name
    Student(){
        //Default construct is "constructor with no parameters"
        System.out.println("This is a default constructor");
        name = "";
        age = 18;
        email = "";
    }

}
