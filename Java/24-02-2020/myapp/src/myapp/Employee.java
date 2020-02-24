/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;
public class Employee {
    //3 fields = 3 properties = 3 attributes
    private String employeeName;
    private String email;
    private Integer age;

    public Employee(String employeeName, String email, Integer age) {
        this.employeeName = employeeName;
        this.email = email;
        this.age = age;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "employee's name : "+this.employeeName+
                "email : "+this.email+
                "age : "+this.age;
    }
    
}
