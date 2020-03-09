package com.example.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    //refactor more for easier to use
    //How to validate the input ?
    public static String validateX(Float x) {
        //return a String is NOT GOOOD, only for simple
        //Not good, if we add validation in Activity
        if(x < 0 || x > 100) {
            return "Value must be in range 0-100";
        }
        return "";
    }
    public static ValidationError validateEmail(String email){
        //let use regex = Regular Expression
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z]+\\.[a-zA-z]{1,3}$");
        if(pattern.matcher(email).matches() == false) {
            return ValidationError.EMAIL_ERROR;
        } else {
            return null;//No error
        }
    }
    public static ValidationError validatePassword(String password){
        if(password.length() < 2) {
            return ValidationError.PASSWORD_ERROR;
        } else {
            return null;//No error
        }
    }
}
