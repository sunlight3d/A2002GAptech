/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;
public class Employee {
    private Float salary;
    //define a property for all objects    
    public static Float BASE_SALARY = 1000.0f;
    public static void aStaticMethod() {
        System.out.println("This is a static method");        
        System.out.println(Employee.BASE_SALARY);//inside static method, we can access to static property
        //How to access this static method ?
        //this.salary = 110.22f; //Can't access instance(salary) property inside a "static method"       
    }
    public void anInstanceMethod() {
        System.out.println(this.BASE_SALARY);
        //inside an instance method, we can access "static method"
    }
}
