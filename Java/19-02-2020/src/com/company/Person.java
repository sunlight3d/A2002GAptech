package com.company;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    protected void run(Float kilometers){
        //public method of "parent class"
        System.out.println("I can run "+kilometers+" km");
    }
    public Boolean isOver18() {
        //method of "parent class"
        return this.age > 18;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
