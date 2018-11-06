package com.sparta.jlb.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeList {

    Map<String, Employee> employeeList;

    public EmployeeList() {
         employeeList = new HashMap<String, Employee>();
    }

    public void addEmployee(String employeeID, Employee value ){
        employeeList.put(employeeID, value);
    }

    public Employee getEmployee(String key ){
        return employeeList.get(key);
    }

    public int numberOfEmployees(){
        return employeeList.size();
    }

    public Map<String, Employee> getEmployeeList() {
        return employeeList;
    }
}
