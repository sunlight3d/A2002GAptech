package com.company;

import com.package2.MyRectangle;

import java.util.Scanner;

public class Book {
    private String bookName = ""; //instance property/variable/attribute
    private Integer isbnNumber = -1;//auto-increment ?? static = apply to all object
    public static Integer numberObjects = 0;
    private String authorName ="";
    private String publisher = "";

    public Integer getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(Integer isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
    //Parameterized constructor
    public Book(String bookName,
                String authorName,
                String publisher) {
        this.bookName = bookName;
        Book.numberObjects++;
        this.isbnNumber = Book.numberObjects;
        this.authorName = authorName;
        this.publisher = publisher;
    }
    //getter, setter
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookInfo(){
        //in an "instance method", we can access "static method/variables"
        //Book.numberObjects = 120;
        return "name:"+bookName+
                ",isbnNumber"+this.isbnNumber+
                ",author: "+this.authorName+
                ",publisher:"+this.publisher;
    }

    @Override //annotations
    public String toString() {
        MyRectangle rectangle = new MyRectangle();

        //String.valueOf(isbnNumber);
        //super = parent's class
        return "name:"+bookName+
                ",isbnNumber"+this.isbnNumber+
                ",author: "+this.authorName+
                ",publisher:"+this.publisher;
    }
    public static Book input() {
        //this.bookName = "aaa";//in static method, we cannot access "instance variable"
        System.out.println("Enter book's name: ");
        String bookName = (new Scanner(System.in)).next();

        System.out.println("Enter author: ");
        String authorName = (new Scanner(System.in)).next();

        System.out.println("Enter publisher: ");
        String publisherName = (new Scanner(System.in)).next();
        //Create an object ?
        //if user enter "wrong author"
        if(authorName.length() < 2) {
            return null;
        } else {
            Book newBook = new Book(bookName, authorName, publisherName);
            return newBook;
        }

    }
    //if input is "instance method", what happened ?
    public void input1() {
        System.out.println("Enter book's name: ");
        String bookName = (new Scanner(System.in)).next();
        this.bookName = bookName;

        System.out.println("Enter author: ");
        String authorName = (new Scanner(System.in)).next();
        this.authorName = authorName;

        System.out.println("Enter publisher: ");
        String publisherName = (new Scanner(System.in)).next();
        this.publisher = publisherName;
    }
    //default constructor
    Book(){
        //bookName = "";
        isbnNumber = -1;
        publisher = "";
        authorName = "";
    }
    {
        //initialization block :
        //no name, run before default

    }
}
