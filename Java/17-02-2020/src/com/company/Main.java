package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        Book cShapBook = new Book(
                "C# for beginner",
                //1,
                "Alex ABC",
                "publisher A");
        //System.out.println(cShapBook.getBookInfo());
        //System.out.println(cShapBook);
        System.out.println("Name = "+cShapBook.getBookName()+
                ",isbn: "+cShapBook.getIsbnNumber()+
                "author's name : "+cShapBook.getAuthorName()+
                "publisher : "+cShapBook.getPublisher() //this also work ok, but not "object oriented mind"
        );

         */
        //Create 30 books
        /*
        System.out.println("Enter number of books: ");
        Scanner scanner = new Scanner(System.in);
        Integer numberOfBooks = scanner.nextInt();
        //We must have a blank array
        ArrayList<Book> books = new ArrayList<Book>();
        for(int i = 0 ; i < numberOfBooks; i++){
            books.add(Book.input());
        }


         */
        //Create a Timer object:
        Timer t1 = new Timer(12, 30, 12);
        System.out.println(t1);
        //change the object
        t1.setTime(13, 40, 13);
        System.out.println(t1);
        Timer t2 = t1.nextSecond();

//        Book aBook = new Book();//still run
//        aBook.input1();
//        Book anotherBook = Book.input();
//        System.out.println("Haha");
        //Test for null value
        Book book3 = new Book();//default constructor
        try {
            if(book3.getBookName().length() < 2){
                System.out.println("book name is too short");
            }
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("End");
        }

    }
}
