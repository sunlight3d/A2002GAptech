/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.data.impl;

import aptech.data.IStudent;
import java.awt.print.Book;
import java.util.Scanner;

public class Student implements IStudent{
    private int id;
    private String studentName, className;    
    private int yearOfBirth;
    private Scanner scanner = new Scanner(System.in);
    public Boolean isUpdate = false;
    public Student() {
    }

    public Student(int id, String studentName, String className, int price) {
        this.id = id;
        this.studentName = studentName;
        this.className = className;
        this.yearOfBirth = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    
    @Override
    public void input() {
        if(isUpdate == false) {
            System.out.print("Enter id: ");
            this.id = this.scanner.nextInt();
        }        
        System.out.print("Enter student's name: ");
        this.scanner = new Scanner(System.in);
        this.studentName = this.scanner.nextLine();
        
        this.scanner = new Scanner(System.in);
        System.out.print("Enter class's name: ");        
        this.className = this.scanner.nextLine();        
        //small exercise ?
        //if user input "year of birth <1987 OR >2005" => no accept, user must re-enter again by again
        this.yearOfBirth = -1;
        while(this.yearOfBirth < 1987 || this.yearOfBirth > 2005) {
            this.scanner = new Scanner(System.in);
            System.out.print("Enter year Of Birth: ");
            this.yearOfBirth = this.scanner.nextInt();
        }
        
    }

    @Override
    public void show() {
        System.out.println("Student's detail: ");
        System.out.println("id: "+this.id);
        System.out.println("Student's name: "+this.studentName);
        System.out.println("Student's className : "+this.className);
        System.out.println("Student's yearOfBirth: "+this.yearOfBirth);
    }
    
}
