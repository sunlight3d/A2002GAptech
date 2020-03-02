/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.impl;

import aptech.data.IDocument;
import java.util.*;

public class Book implements IDocument{
    private int id;
    private String bookName;
    private String authorName;
    private float price;
    private Scanner scanner = new Scanner(System.in);
    public Book() {
    }

    public Book(int id, String bookName, String authorName, float price) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }
    
    @Override
    public void input() {
        System.out.println("Enter id : ");
        this.id = scanner.nextInt();
        System.out.println("Enter book's name : ");
        //this.setBookName(bookName); //no neccessay call setter inside the own class
        scanner = new Scanner(System.in);
        this.bookName = scanner.nextLine();

        System.out.println("Enter author name : ");        
        
        scanner = new Scanner(System.in);
        this.authorName = scanner.nextLine();
        
        
        System.out.println("Enter book's price : ");        
        scanner = new Scanner(System.in);
        this.price = scanner.nextFloat();
    }

    @Override //implement method in the interface
    public void show() {
        System.out.println("Book's id: "+this.id);  
        System.out.println("Book's name: "+this.bookName);  
        System.out.println("Book's author: "+this.authorName);  
        System.out.println("Book's price: "+this.price);  
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
}
