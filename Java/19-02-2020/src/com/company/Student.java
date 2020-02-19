package com.company;
//Student = sub class = child class of Person
public class Student extends Person {
    private Integer studentNumber;
    Student(String name, int age, Integer studentNumber) {
        super(name, age);//super = "this" of "parent class"(Person)
        //"super(name, age)" = constructor of Person
        this.studentNumber = studentNumber;
    }

    @Override //Annotation
    public void run(Float kilometers) {
        //super.run(kilometers);
        System.out.println("Student can run "+kilometers+" km");
    }
}
