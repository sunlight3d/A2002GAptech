/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.data.test;

import aptech.data.manager.StudentManager;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {                
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        int choice = -1;        
        while(choice != 6) {
            System.out.println("1. Add New Students");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Students By Class Name");
            System.out.println("4. Delete Students By Class Name");
            System.out.println("5. Update student with id");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : "); choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:
                    studentManager.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Enter class's name to search: ");                   
                    studentManager.searchByClassName(new Scanner(System.in).nextLine());
                    break;
                case 4:
                    System.out.println("Enter class's name to delete: ");                    
                    studentManager.deleteByClassName(new Scanner(System.in).nextLine());
                    break;
                case 5:
                    System.out.println("Enter id to delete: ");                    
                    studentManager.updateStudent();
                    break;
            }
        }
        System.out.println("This program is ended");
    }
}
