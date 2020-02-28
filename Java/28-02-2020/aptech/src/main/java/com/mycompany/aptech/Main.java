/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aptech;

import java.util.*;

public class Main {
    public static void main(String[] arguments) {        
        String choice = "yes";
        Rectangle rX = new Rectangle("xx", 1, 2, "red", true);
        while(choice.toLowerCase().trim().equals("yes")) {
            GeometricManager geometricManager = new GeometricManager();
            geometricManager.inputRectangles();
            geometricManager.displayRectangles();
            //geometricManager.sortByColor(SortType.Descending);
            //geometricManager.updateARectangle();
            //geometricManager.seachRectangles();
            //geometricManager.deleteARectangle();
            //geometricManager.displayRectangles(); 
            geometricManager.cloneARectangle(rX);
            System.out.println("Do you want to continue(yes, no) ?");
            choice = (new Scanner(System.in)).nextLine();            
        }
    }
        
}
