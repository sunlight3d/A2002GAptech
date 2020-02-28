/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aptech;

import java.util.*;
import java.util.stream.*;

public class GeometricManager {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    public void inputRectangles() {
        //We create several Rectangle objects, sort by area 
        //How to create Rectangle objects ? Use fake objects / use Scanner
        //way 1 - fake = "unreal"
        /*
        Rectangle r1 = new Rectangle("a", 100.0, 2.0, "red", false); //area = 6
        Rectangle r2 = new Rectangle("b", 10.0, 1.0, "yellow", false);//area = 4
        Rectangle r3 = new Rectangle("c", 2.0, 2.0, "blue", false);//area = 8
        Rectangle r4 = new Rectangle("d", 0.5, 0.5, "green", false);//area = 2
        rectangles.add(r1);
        rectangles.add(r2);
        rectangles.add(r3);
        rectangles.add(r4);
        */
        //way 2: Input from Keyboard
        System.out.println("How many rectangle do you want to input : ");
        int numberOfRectangles = this.scanner.nextInt();
        for(int i = 0; i < numberOfRectangles; i++) {
            System.out.println("Rectangle "+(i+1)); 
            System.out.print("Enter name :"); 
            //error in scanner object, it get the "\n"
            //Fix ?
            this.scanner = new Scanner(System.in);
            String rectangleName = this.scanner.nextLine();
            
            System.out.print("Enter width :"); 
            Double rectangleWidth = this.scanner.nextDouble();

            System.out.print("Enter height :"); 
            Double rectangleHeight = this.scanner.nextDouble();            
            
            this.scanner = new Scanner(System.in);
            System.out.print("Enter color :"); 
            String rectangleColor = this.scanner.nextLine();
            
            System.out.print("Is it filled(No, Yes) ? :"); 
            String isFilled = this.scanner.nextLine();
            
            Rectangle newRectangle = new Rectangle(rectangleName, 
                    rectangleWidth, 
                    rectangleHeight, 
                    rectangleColor, 
                    isFilled.toUpperCase().equals("YES"));
            this.rectangles.add(newRectangle);
        }
    }
    public void sortByColor(SortType sortType){
        //1: descending, 0: ascending => NOT GOOD
        //Let's us Enumeration(data type that have several values)
        rectangles.sort((rectangleA, rectangleB) -> {
            //anynomous method/function
            //compareTo is a method of Double(a class), not double(not a class)\
            //How to sort Descending: [bigger, smaller, smaller... smallest]
            //sort by area
            //return rectangleB.getArea().compareTo(rectangleA.getArea()); //-1, 0, +1
            //How to sort by color
            return (sortType == SortType.Ascending ? 1 : -1) *
                    rectangleA.getColor().compareTo(rectangleB.getColor()); //-1, 0, +1
        });
        
        System.out.println("Array: "+rectangles.toString());
    }
    public void updateARectangle() {
        Boolean isFound = false;
        //for example, only update color
        System.out.println("Enter rectangle's name you want to modify ?");
        String rectangleName = this.scanner.nextLine();
        //Search rectangleName and modify
        //How to search: for-loop + check
        for(Rectangle rectangle: this.rectangles) {
            //equals = compare string's content
            if(rectangle.getName().equals(rectangleName)) {
                //What about "NOT FOUND" ?
                //found !
                isFound = true;
                try {
                    System.out.println("Enter rectangle's color you want to modify ?");
                    rectangle.setColor(scanner.nextLine());

                    System.out.println("Enter rectangle's width you want to modify ?");
                    rectangle.setWidth(scanner.nextDouble());

                    System.out.println("Enter rectangle's height you want to modify ?");
                    rectangle.setHeight(scanner.nextDouble());
                    System.out.println("Update successful");
                }catch(Exception error) {
                    System.err.println("Cannot update. Reason : "+error);
                } finally {
                    System.out.println("End of update function");
                }                                
            }            
        }
        //outside the for loop
        if(isFound == false) {
            System.out.println("Cannot find Rectangle to update !");
        }
        
    }
    //Now how to search an object in an ArrayList
    //Search a Rectangle with criteria: width >= 0.0(minWidth) AND width <= 5.0(maxWidth)
    public void seachRectangles() {
        //1.input minWidth, maxWidth from the keyboard 
        System.out.print("Enter min width : ");
        Double minWidth = this.scanner.nextDouble();
        System.out.print("Enter max width : ");
        Double maxWidth = this.scanner.nextDouble();
        //way 1 - the easy, classical way, but lower if your list is very long        
        /*
        ArrayList<Rectangle> result = new ArrayList<>();
        for(Rectangle eachRectangle: this.rectangles) {
            if(eachRectangle.getWidth() >= minWidth 
                    && eachRectangle.getWidth() <= maxWidth) {
                //found!
                result.add(eachRectangle);
            }
        }
        System.out.println(result);
        */
        //way 2: use filter function, faster, better
        ArrayList<Rectangle> result = (ArrayList<Rectangle>)this.rectangles
                .stream()
                .filter(eachRectangle -> {
                        //this function return to true/false
                        return eachRectangle.getWidth() >= minWidth 
                                && eachRectangle.getWidth() <= maxWidth;
                })
                .collect(Collectors.toList());
        System.out.println(result);
    }
        
    //How to delete/remove an item in ArrayList ?
    //Let's use FILTER 
    public void deleteARectangle() {
        System.out.println("Enter rectangle's name you want to DELETE ?");
        String rectangleName = this.scanner.nextLine();
        ArrayList<Rectangle> result = (ArrayList<Rectangle>)this.rectangles
                .stream()
                .filter(eachRectangle -> {
                        //this function return to true/false
                        return !eachRectangle.getName().equals(rectangleName);
                })
                .collect(Collectors.toList());
        if(result.size() < this.rectangles.size()) {            
            this.rectangles = result;
            System.out.println("Delete successfully");
        } else {
            System.out.println("Cannot find rectangle to delete");
        }
    }
    //Now cloning a rectangle
    public Rectangle cloneARectangle(Rectangle rect){
        //way 1: simple, manual
        /*
        Rectangle anotherRectangle = new Rectangle(
                rect.getName(),
                rect.getWidth(),
                rect.getHeight(),
                rect.getColor(),
                rect.getFilled()
        );
        return anotherRectangle;
*/
        //way 2
        Rectangle anotherRectangle = rect.clone();
        System.out.println("haha");
        return anotherRectangle;
    }
    public void displayRectangles(){
        int i = 0;
        for(Rectangle rectangle: this.rectangles) {
            i++;
            System.out.println(i+"."+rectangle.toString());
        }
    }
}
