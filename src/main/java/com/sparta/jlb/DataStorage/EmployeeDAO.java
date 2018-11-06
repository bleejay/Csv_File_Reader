package com.sparta.jlb.DataStorage;

import com.sparta.jlb.Model.Employee;
import com.sparta.jlb.Model.EmployeeList;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmployeeDAO {

    private final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "system";
    private final String PASSWORD = "Acad3my1";
    private String query = "INSERT INTO newEmployees(Emp_ID, Name_Prefix, First_Name, Middle_Initial, Last_name, Gender, Email, Date_of_Birth, Date_of_Joining, Salary) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private Connection connection;

    public void addEmployee(Employee employee){
        boolean isLocalConnection = false;
        query = "INSERT INTO newEmployees(Emp_ID, Name_Prefix, First_Name, Middle_Initial, Last_name, Gender, Email, Date_of_Birth, Date_of_Joining, Salary) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            if (connection == null){
                connection = DriverManager.getConnection(PATH, USER, PASSWORD);
                isLocalConnection = true;
            }
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getEmployeeID());
            statement.setString(2, employee.getNamePrefix());
            statement.setString(3, employee.getFirstName());
            statement.setString(4, employee.getMiddleInitial());
            statement.setString(5, employee.getLastName());
            statement.setString(6, employee.getGender());
            statement.setString(7, employee.getEmail());
            statement.setDate(8, Date.valueOf(employee.getDateOB()));
            statement.setDate(9, Date.valueOf(employee.getStartDate()));
            statement.setInt(10, employee.getSalary());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (isLocalConnection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addEmployees(Collection<Employee> newEmployees){
        try (Connection connection = DriverManager.getConnection(PATH, USER, PASSWORD)){
            for (Employee employee: newEmployees){
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, employee.getEmployeeID());
                statement.setString(2, employee.getNamePrefix());
                statement.setString(3, employee.getFirstName());
                statement.setString(4, employee.getMiddleInitial());
                statement.setString(5, employee.getLastName());
                statement.setString(6, employee.getGender());
                statement.setString(7, employee.getEmail());
                statement.setDate(8, Date.valueOf(employee.getDateOB()));
                statement.setDate(9, Date.valueOf(employee.getStartDate()));
                statement.setDouble(10, employee.getSalary());
                statement.executeUpdate();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public Employee getEmployee(String employeeID){
//
//        ;
//
//    }
//
//    public void updateEmployeeInfo(String employeeID, String Field){
//
//        getEmployee(employeeID);
//    }
//
//    public void deleteEmployee(){
//
//    }

}
