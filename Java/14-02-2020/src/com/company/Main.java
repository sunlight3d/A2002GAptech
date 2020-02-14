package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Student mrHean = new Student();
        Student mrHean = new Student(
                "Hean Chandaroth",
                18,
                "haen@gmail.com");
        mrHean.gotoSchool();
        mrHean.gotoWork();
        Long card = 1123_1234_999L;
        Integer x2 = 1123;
        System.out.println("card number is : "+card);

        Student msMeng = new Student();
        Point pointA = new Point(1.0f,1.0f, "red");
        System.out.println("Distance from zero = "+pointA.distanceFromO());


//        msMeng.name = "Meng Sokreat";
//        msMeng.age = 19;
//        msMeng.email = "meng@gmail.com";
        //when you initializing an object, it has "memory allocation"


//        int x = 2;
//        Integer[] numbers = {1, 5, 6, 7, 12};
        //simplest form
        /*
        for(int i = 0; i < numbers.length; i++){
            System.out.println("i = "+i+",number = "+numbers[i]);
        }
        */
        //faster to iterate
        /*
        for(Integer number: numbers) {
            System.out.println("number = "+number);
        }
        ArrayList<Float> someFloats = new ArrayList<>();
        someFloats.add(5.0f);
        someFloats.add(7.5f);
        someFloats.add(5.1f);
        */

        //iterate the array list
        //basic : for-loop
        /*
        for(int i = 0; i < someFloats.size(); i++) {
            System.out.println("float value = "+someFloats.get(i));
        }
        */
        //faster
        /*
        someFloats.forEach(eachNumber -> {
            System.out.println("eachNumber ="+eachNumber);
        });
        */
        /*
        Integer y = 3;
	    System.out.println("Value of x = "+x);
	    System.out.println("max value of Integer = "+Integer.MAX_VALUE);
	    if(x > 0) {
            System.out.println("x is bigger than 0");
        }
        */
	    //calculate
        //get the first timestamp in miliseconds
        /*
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            Integer z = (int)Math.pow(x, 2) + (int) Math.pow(x, 3);
            System.out.println(i + ". Value of z = "+z);
        }
        //get the second timestamp in miliseconds
        long t2 = System.currentTimeMillis();
        long duration = t2-t1;
        System.out.println("Duration : "+duration);

         */
    }
}
