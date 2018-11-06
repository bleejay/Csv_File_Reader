package com.sparta.jlb.Control;

import com.sparta.jlb.DataStorage.EmployeeDAO;
import com.sparta.jlb.Model.Employee;
import com.sparta.jlb.Model.EmployeeList;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class EmployeeReader {
    EmployeeList employeeList = new EmployeeList();

    public EmployeeList readFile(String PATH) {

        String line;
        String csvSplitBy = ",";
        EmployeeList employeeList = new EmployeeList();


        try {
            Reader reader = new BufferedReader(new FileReader(PATH));
            ((BufferedReader) reader).readLine();

            while ((line = ((BufferedReader) reader).readLine()) != null) {
                String[] employee = line.split(csvSplitBy);
                Employee newEmployee = new Employee(employee[0], employee[1], employee[2], employee[3], employee[4], employee[5], employee[6], toDate(employee[7]), toDate(employee[8]), employee[9]);
                employeeList.addEmployee(newEmployee.getEmployeeID(), newEmployee);

            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    public EmployeeList streamReader(String Path) {

        String csvSplitBy = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(Path))){

            reader.lines()
                    .skip(1)
                    .map(line -> line.split(csvSplitBy))
                    .forEach(employee -> {
                        Employee newEmployee = null;
                        try {
                            newEmployee = new Employee(employee[0], employee[1], employee[2], employee[3], employee[4], employee[5], employee[6], toDate(employee[7]), toDate(employee[8]), employee[9]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        employeeList.getEmployeeList().put(employee[0], newEmployee);
                        if (employeeList.getEmployeeList().size() == 2000){
                            sendBatch();
                        }
                    });
            sendBatch();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    private void sendBatch(){
        Collection<Employee> batch = new HashSet<>(employeeList.getEmployeeList().values());
        addToDataStoreThreaded(batch);
        employeeList.getEmployeeList().clear();
    }

    private LocalDate toDate(String dateToChange){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(dateToChange, formatter);
    }

    private void addToDataStoreThreaded(Collection<Employee> records){
        Runnable runnable = () -> {
            EmployeeDAO dao = new EmployeeDAO();
            dao.addEmployees(records);
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


}
