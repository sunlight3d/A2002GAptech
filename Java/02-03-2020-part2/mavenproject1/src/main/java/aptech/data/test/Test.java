/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.data.test;

import aptech.data.manager.DocumentManager;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //show menu 
        DocumentManager documentManager = new DocumentManager();
        System.out.println("1. Add New Books");
        System.out.println("2. Display All Books");
        System.out.println("3. Search Books By Author Name");
        System.out.println("4. Exit");            
        int choice = 0;
        while(choice != 4) {            
            //int choice = (new Scanner(System.in)).nextInt(); //this can prevent enter key
            //int choice = this.scanner; //NO, because scanner is "NON - static"
            System.out.println("Please choose(1,2,3,4):");
            choice = scanner.nextInt();//ok because scanner is also "static"
            switch(choice) {
                    case 1:
                        //documentManager.addDocument();
                        //Test break ?
                        documentManager.addDocument();
                        //documentManager.doSomething();
                        break;
                    case 2:
                        //documentManager.addDocument();
                        //Test break ?
                        documentManager.displayAllDocument();
                        break;
                    case 3:
                        //documentManager.addDocument();
                        //Test break ?
                        System.out.println("Enter author's name to search : ");
                        String authorName = (new Scanner(System.in)).nextLine();
                        documentManager.searchByAuthorName(authorName);
                        break;
                    case 4:
                        //documentManager.addDocument();
                        //Test break ?
                        System.out.println("you choose 4");
                        break;
                    default:
                        //how to fix ?
                        //way 1: add choice outside whilw loop(easy)
                        //way 2: change switch to if-else(not good)
                        break;                
            }
       }
        System.out.println("End program");
    }
}
