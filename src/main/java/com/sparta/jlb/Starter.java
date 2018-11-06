package com.sparta.jlb;

import com.sparta.jlb.Control.EmployeeManager;

public class Starter
{
    public static void main( String[] args ) {

        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.readFile();
//       employeeManager.displayInfo();

    }
}
