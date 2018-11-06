//package com.sparta.jlb.DataStorage;
//
//import java.sql.*;
//
//public class DataBaseCreator {
//
//    private final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
//    private final String USER = "system";
//    private final String PASSWORD = "Acad3my1";
//    private final String QUERY = "create table newEmployees(Emp_ID varchar(20), Name_Prefix varchar(10), First_Name varchar(20), Middle_Initial varchar(5), Last_name varchar(20), Gender varchar(10), Email varchar(50), Date_of_Birth Date, Date_of_Joining Date, Salary Number(10))";
//
//    public void createTable (){
//
//    try(Connection connection = DriverManager.getConnection(PATH, USER, PASSWORD)){
//
//        PreparedStatement statement = connection.prepareStatement(QUERY);
//        statement.executeUpdate();
//        System.out.println("Table Created");
//
//    }catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
