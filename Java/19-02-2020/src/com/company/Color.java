package com.company;

public class Color {
    private Integer red, green, blue;
    Color(){
        this.red = 0;
        green = 0;
        blue = 0;
    }
    //constructor 2 params
    Color(int red, int green){
        this.red = red;
        this.green = green;
        this.blue = 255;
    }
    //constructor 3 params
    //overloading a constructor
    Color(int red, int green, int blue) {
        this.red= red;
        this.green = green;
        this.blue = blue;
    }
}
