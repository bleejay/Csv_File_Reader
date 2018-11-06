package com.sparta.jlb.Model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    private String employeeID;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dateOB;
    private LocalDate startDate;
    private int salary;

    public Employee(String employeeID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, LocalDate dateOB, LocalDate startDate, String salary) throws ParseException {

        this.employeeID = employeeID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOB = dateOB;
        this.startDate = startDate;
        this.salary = Integer.parseInt(salary);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOB() {
        return dateOB;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getSalary() {
        return salary;
    }

//    private LocalDate changeDate(String dateToChange){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
//        return LocalDate.parse(dateToChange, formatter);
//    }
}
