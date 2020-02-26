/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

/**
 *
 * @author User
 */
public class Myapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create a object using "default constructor"
        //test object
        
//        System.out.println("haha");
//        Department itDepartment = new Department();
//        itDepartment.setDepartmentName("IT Department");
//        itDepartment.setDepartmentId(1);
//        itDepartment.setDescription("This is IT dept of this company");
        
        //create object using "constructor with parameters"
//        Department salesDepartment = new Department("Sales department", 
//                2, "This is Sales Dept");
//        System.out.println(salesDepartment.toString());
//        System.out.println(itDepartment.toString());
//        //create mrHoang, mrA Employee's objects 
//        Employee mrHoang = new Employee("Hoang", 
//                "hoang@gmail.com", 
//                30);//create/initialize mrHoang object using Constructor
//        Employee mrA = new Employee("A abc", "mra@yahoo.com", 18);
//        //mrA and mr Hoang are in "IT Department"
//        itDepartment.getEmployees().add(mrHoang);
//        itDepartment.getEmployees().add(mrA);
//        System.out.println("haha");
//        System.out.println(itDepartment.toString());
        //create a new Point ?
        MovablePoint point1 = new MovablePoint(0, 0, 1, 2);
        MovableCircle circleA = new MovableCircle(0, 0, 1, 2, 10);
        //point1 and circleA.center has the same data
        //But point1 and circleA.center are in DIFFERENT "memory address" 
        System.out.println("haha");
        //Now if you want circleA has center = point1 ?
        circleA.setCenter(point1);
        System.out.println("hehe");
        // now circleA.center and point1 has the SAME "memory address"
        System.out.println(point1.toString());
        System.out.println(circleA.toString());
  }
    
}
