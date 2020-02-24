/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Department {
    //private = "can't access(hidden) outside this class"
    private String departmentName;
    private int departmentId;
    private String description;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    Department() {
        this.departmentName = "";
        this.departmentId = 0;
        this.description = "";
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Department(String departmentName, 
            int departmentId, String description) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        this.description = description;
    }

    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        //concatenate(merge, add) strings
        //You must display details of "employees"
        String employeeDetail = "";
        for(Employee eachEmployee: this.employees) {
            employeeDetail += "\n" + eachEmployee.toString();
        }
        return employeeDetail+
                "\ndepartment's name :"+this.departmentName+
                "\nid : "+this.departmentId+
                "\ndescription : "+this.description;
                
    }
    
}
