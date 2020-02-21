/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;
import java.util.*;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Person p1 = new Person("Hoang");
        p1.setAddress("somewhere in the world...");

        Staff staffA = new Staff("abc", "address aa ","Shcool A", 123.1);
        Staff staffB = new Staff("bbb", "address bb ","Shcool BB", 223.1);

        Student studentA = new Student("saa", "add ssaa", "Java", 2020, 22222.0);//Ctrl + Space
        Student studentB = new Student("sbbb", "add bbb", "PHP", 2019, 11111.0);
        ArrayList<Student> students = new ArrayList<Student>();//press Alt+Enter to import library
        students.add(studentA);
        students.add(studentB);
        //students.add(staffA);
        ArrayList<Person> persons = new ArrayList<Person>();//ArrayList = "a generics Class"
        persons.add(studentA);
        persons.add(staffA);
        persons.add(studentB);
        persons.add(staffB);
        persons.forEach(eachPerson -> {
            if(eachPerson instanceof Student) {
                System.out.println(((Student)eachPerson).toString() + ", is a student");
            } else if(eachPerson instanceof Staff) {
                System.out.println(((Staff)eachPerson).toString() + ", is a staff");
            }
        });
//        int x = 120;
//        int[] numbers = {1,2,3};
//        persons.add(numbers);
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Priscilla Wagne");
        strings.add("Elvis Presley nishjr e iuhjerw re");
        strings.add("Tom Parker");
        //way 1, sort by lenght and get the first
        //way 1 is better
        strings.sort((s1, s2) -> {
            return s2.length() - s1.length();
        });
        if(strings.size() > 0) {
            System.out.println("Longest name is :"+strings.get(0));
        }
        //way 2
        int maxLenght = 0;
        for(String eachString: strings) {
            if(eachString.length() > maxLenght) {
                maxLenght = eachString.length();
            }
        }
            
        for(String eachString: strings) {
            if(eachString.length() == maxLenght) {
                System.out.println("Longest name is :"+eachString);
            }
        }
        

        ArrayList<Person> anotherPersons = new ArrayList<Person>();
        anotherPersons.add(new Person("Priscilla","Wagner"));
        anotherPersons.add(new Person("Tom","Parker jijeirwjiriejriej ijijireji"));
        anotherPersons.add(new Person("Elvis ","Presley"));
        /*
        anotherPersons.sort((pA, pB) -> {
            return pB.getFullName().length() - pA.getFullName().length();
        });
                */
        
        ArrayList<Person>  persons2 = (ArrayList<Person>)anotherPersons.clone();
        //clone = make a copy 
        persons2.sort((pA, pB) -> {
            return pB.getFullName().length() - pA.getFullName().length();
        });
        System.out.println("Longest name is :"+persons2.get(0).getFullName());
        System.out.println("Testing interfaces");
        Person mrHoang = new Person("Hoang");
        ArrayList<String> books = new ArrayList<String>();
        books.add("Java programming"); books.add("PHP Laravel");
        mrHoang.borrowSomeBooks(books);
        mrHoang.gotoLibrary("Aptech Library");
        mrHoang.playFootball("somewhere");
        mrHoang.playTennis();
        
        Worker workerA = new Worker();
        workerA.playFootball("AAA");
        workerA.playTennis();
        workerA.gotoLibrary("aptech libbbbb");
        
        
    }

}
