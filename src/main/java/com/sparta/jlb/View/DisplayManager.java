package com.sparta.jlb.View;

import com.sparta.jlb.Model.Employee;

public class DisplayManager {


    public void displayNumberOfEmployees(int numberOfEmployees){
        System.out.println("Total number of employees = " + numberOfEmployees);
    }

    public void displayEmployeeInfo(Employee value) {
        System.out.println("ID = " + value.getEmployeeID() + " | Name: " + value.getNamePrefix() + " " + value.getFirstName() + " " + value.getMiddleInitial() + " " + value.getLastName() + " | Gender = " + value.getGender() + " | Email = " + value.getEmail() + " | DoB = " + value.getDateOB() + " | Start Date = " + value.getStartDate() + " | Salary = £" + value.getSalary());
    }

    public void displayEmployeeID(Employee value){
        System.out.println("ID = " + value.getEmployeeID());
    }

    public void displayEmployeeFullName(Employee value){
        System.out.println("Name: " + value.getNamePrefix() + " " + value.getFirstName() + " " + value.getMiddleInitial() + " " + value.getLastName());
    }
}
