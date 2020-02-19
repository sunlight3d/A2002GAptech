package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Initializing a matrix
//        Matrix matrix1 = new Matrix(3,3);
//        matrix1.setValue(0,1, 120.0);
//        System.out.println("Haha");
        /*
        Matrix m1 = new Matrix();
        m1.input();
        System.out.println("Haha");
        Matrix m2 = new Matrix();
        m2.input();
        m1.add(m2);
        System.out.println(m1.toString());

         */
        /*
        Student studentA = new Student("Hoang",
                17,
                123);
        studentA.setAge(31);//call "public method" of "parent class"
        studentA.run(1.2f);
        System.out.println("Is his over 18 ? "+studentA.isOver18());

         */
        /*
        Color color1 = new Color();
        Color color2 = new Color(0, 120);
        Color color3 = new Color(120, 130, 140);
        System.out.println("haha");
        */
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(4);
        numbers.add(6);
        //iterate an array list
        for(int i = 0; i < numbers.size(); i++){
            System.out.println("number at "+i+" ="+numbers.get(i));
        }
        //iterate an array list(better)
        for(Integer number: numbers) {
            System.out.println("number ="+number);
        }
        //iterate an array list(better)
        numbers.forEach(eachNumber -> {
            System.out.println("number ="+eachNumber);
        });
        numbers.sort((number1, number2) -> {
            //lambda = anonymous/no-name function = "arrow function"
            return number1 < number2 ? -1 : 1;
        });
        //old method, slower, more complicated, don't use !
        for(int i = 0; i < numbers.size()-1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) > numbers.get(j)) {
                    //swap ...
                }
            }
        }

        //How to sort an array list of Object ?
        Student studentA = new Student(
                "Hoang", 30, 11);
        Student studentB = new Student(
                "Xaa B", 35, 33);
        Student studentC = new Student(
                "Bill C", 32, 22);
        List<Student> students = new ArrayList<>();
        students.add(studentA);
        students.add(studentB);
        students.add(studentC);
        System.out.println("Haha");
        students.sort((student1, student2) -> {
            return student1.getAge() < student2.getAge() ? -1 : 1;
        });
        students.sort((student1, student2) -> {
            return student2.getName().compareTo(student1.getName());
        });

        System.out.println("HAha");
    }
}
