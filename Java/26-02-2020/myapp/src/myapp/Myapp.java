/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import java.util.ArrayList;

public class Myapp {
    public static void main(String[] args) {
        // TODO code application logic here
//        Table table = new Table();
//        table.name = "aaa";
//        //test
//        Employee e1 = new Employee();
//        //Employee.BASE_SALARY = 123; //You don't to create Employee obj to access static member
//        System.out.println(Employee.BASE_SALARY);
//        Employee.aStaticMethod();
        
        /*
        Table tableA = new Table(10.23, 5.35);
        System.out.println("Area of tableA = "+tableA.getArea(0));                
        TableManagement tableManagement = new TableManagement();
        tableManagement.inputTables();
        tableManagement.displayTables();
        
        //create an PhotoAlBum object
        PhotoAlbum photoAlbum = new PhotoAlbum();//callling default constructor
        //calling constructor with params
        //create object
        PhotoAlbum photoAlbum2 = new PhotoAlbum(30);
        System.out.println(photoAlbum2);
                */
        
        /*
        try {
            method();
            System.out.println("After call method");
        } catch(RuntimeException e) {
            //if I want "If error, go to here", how to do ?
            System.out.println("RuntimeException in Main");
        } catch(Exception e) {
            System.out.println("Exception  in Main");
        }
                */
        //Shape shape = new Shape();//We cannot call the CONSTRUCTOR of an abstract class
        
        //Because "abstract class" is "unfinished"
        System.out.println(IPlayabe.aStaticVariable);
        System.out.println(Shape.aStaticVariable2);
        //create a Student's object
        Human studentA = new Student("yellow", 
                "Hanoi University of Science and Technology");
        //You can reference a "parent class" object to the "child class"
        System.out.println(studentA);
        //check object's type
        if(studentA instanceof Student) {
            System.out.println("studentA is a STudent ");
        }
    }
    static void method() throws Exception{
        //Exception is super class of RuntimeException
        try {
            String abc = "abc";
            System.out.println(abc.charAt(3)); //exception is here
            System.out.println("Haha");
//it compile successful, 
            //because "no syntax error"
        } catch(RuntimeException e) {
            System.out.println("RuntimeException");
            throw e;
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }
}
