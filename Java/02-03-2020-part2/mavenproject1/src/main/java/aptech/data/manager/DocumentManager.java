/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.data.manager;

import aptech.data.IDocument;
import data.impl.Book;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

public class DocumentManager {
    private ArrayList<Book> books = new ArrayList<Book>();
    private int numberOfBooks = 0;
    private Scanner scanner = new Scanner(System.in);//press Alt+Enter to show "hint"
    public void addDocument()  {
        System.out.println("Number of books to store : ");
        this.numberOfBooks = scanner.nextInt();
        for(int i = 0; i < numberOfBooks; i++) {
            Book newBook = new Book();
            newBook.input();
            this.books.add(newBook);
        }
    }
    public void displayAllDocument() {
        //ArrayList<T> is called a "Generics Class/Type"
        //Ex: ArrayList<Book>, Type = Book        
        //iterate an arraylist
        int i = 0;
        for(Book eachBook: this.books) {
            //iterate a list of books
            System.out.println("Book "+(i+1));
            eachBook.show();
            i++;
        }        
    }
    //it is "default", means : class Test cannot access(different package)   
    public void searchByAuthorName(@Nonnull String authorName) {
        //search = filter = "query"        
        ArrayList<Book> result = (ArrayList<Book>)this.books.stream().filter(
                //lambda function = anonymous function
                eachBook -> {
                    //return eachBook.getAuthorName().equals(authorName);
                    //if you want to compare with "ignore uppercase/lowercase" ?                    
                    return (eachBook.getAuthorName().toLowerCase()).equals(authorName.toLowerCase());
                }
        ).collect(Collectors.toList());     
        if(result.isEmpty()) {
            System.out.println("Cannot find books with author's name : "+authorName);
        } else {
            for(Book eachBook: result) {
            //iterate a list of books            
                eachBook.show();           
            }
        }
        
    }
    //We a a Deprecated function = "This function will be removed in the future version"
    //But now, we still use it
    //Example
    @Deprecated
    @SuppressWarnings("Please use searchByAuthorName instead") //warning to developer
    //when do you use this ? In big project, many customers use your function, you write your own library
    public void doSomething(){
        System.out.println("Do something");
    }
}
