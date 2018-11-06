package com.sparta.jlb.Control;

import com.sparta.jlb.DataStorage.EmployeeDAO;
import com.sparta.jlb.Model.Employee;
import com.sparta.jlb.Model.EmployeeList;
import com.sparta.jlb.View.DisplayManager;

import java.util.Collection;
import java.util.HashSet;


public class EmployeeManager {

    EmployeeList employeeList;
    EmployeeReader employeeReader;
    EmployeeDAO employeeDAO;

    public void readFile(){
       employeeReader = new EmployeeReader();
       employeeList = employeeReader.streamReader("resources/EmployeeRecords.csv");
//       employeeDAO = new EmployeeDAO();
//       employeeDAO.addEmployees(employeeList.getEmployeeList());
    }

    public void displayInfo(){

        DisplayManager displayManager = new DisplayManager();
        displayManager.displayNumberOfEmployees(employeeList.numberOfEmployees());
        displayManager.displayEmployeeInfo(employeeList.getEmployee("138700"));
    }

    public Collection getCollection(EmployeeList employeeList){
        Collection<Employee> batch = new HashSet<>(employeeList.getEmployeeList().values());
        return batch;
    }

}
