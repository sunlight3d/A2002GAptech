/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.data.manager;

import aptech.data.impl.Student;
import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<Student>();
    public void addStudent(){
        System.out.println("Number of students : ");
        int numberOfStudents = scanner.nextInt();
        for(int i = 0 ; i < numberOfStudents; i ++ ){
            Student student = new Student();
            student.input();
            this.students.add(student);
        }
    }
    public void displayAllStudents() {
        int i = 0;
        for(Student student: this.students) {
            i++;
            System.out.println("Student :"+i);
            student.show();
        }        
    }
    public void searchByClassName(String className) {
        //search = filter        
        ArrayList<Student> result = 
        (ArrayList<Student>)this.students.stream().filter(student -> {
            return student.getClassName().equalsIgnoreCase(className);
        }).collect(Collectors.toList());
        //show result ?
        if(result.isEmpty()) {
            System.err.println("Cannot find student with class's name : "+className);
        } else {
            System.out.println("We found "+result.size()+" students");
            for(Student student: result) {
                student.show();
            }
        }
    }
    public void updateStudent() {
        System.out.println("Enter student's id to update");
        int id = scanner.nextInt();
        ArrayList<Student> result = 
        (ArrayList<Student>)this.students.stream()
                .filter(student -> student.getId() == id)
                .collect(Collectors.toList());
        if(result.isEmpty()) {
            System.err.println("Cannot find student with id ="+id+" to update");
        } else {
            Student foundStudent = result.get(0);
            foundStudent.isUpdate = true;
            foundStudent.input();
        }        
    }
    public void deleteByClassName(String className) {
        //delete = remove
//        this.students.removeIf(student -> {
//            return student.getClassName().equalsIgnoreCase(className);
//        });
        //if the "condition's function"(lambda expression) has 1 LINE, let do as here
        this.students.removeIf(student -> student.getClassName().equalsIgnoreCase(className));
        //delete = filter        
    }
    
}
