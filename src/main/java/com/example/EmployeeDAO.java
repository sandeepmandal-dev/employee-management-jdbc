package com.example;

import java.sql.*;
import java.util.Collections;

public class EmployeeDAO {

 public void AddEmployee(Employee employee){
     String sqlQuery="Insert into employees(name,department,salary) values(?,?,?)";

     try(Connection connection=DBConnection.getConnection();
         PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery)){

         preparedStatement.setString(1,employee.getName());
         preparedStatement.setString(2,employee.getDepartment());
         preparedStatement.setInt(3,employee.getSalary());

         int row=preparedStatement.executeUpdate();

         if(row>0){
             System.out.println("Employee Added");
         }
     }catch (Exception e){
          e.printStackTrace();
     }
 }

 public void ViewEmployee(){
     String sqlQuery="select * from employees";
     try(Connection connection=DBConnection.getConnection();
         Statement statement=connection.createStatement();
         ResultSet resultSet=statement.executeQuery(sqlQuery)) {

         while (resultSet.next()){
             System.out.println(
                     resultSet.getInt("id")+ " |" +
                     resultSet.getString("name")+ "|"+
                     resultSet.getString("department") + " | " +
                     resultSet.getInt("salary")
             );
         }

     }catch (SQLException e){
         e.printStackTrace();
     }
    }

    public void UpdateEmployee(int id,int salary){

     String sqlQuery= "UPDATE employees SET salary=? WHERE id=?";

     try(Connection connection=DBConnection.getConnection();
     PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery)){

         preparedStatement.setInt(1,salary);
         preparedStatement.setInt(2,id);

         int row=preparedStatement.executeUpdate();
         if(row>0){
             System.out.println("Employee details updated");
         }

     }catch (SQLException e){
         e.printStackTrace();
     }
    }

    public void DeleteEmpolyee(int id){
     String sqlQuery="DELETE FROM employees WHERE id=?";

     try(Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery)){

         preparedStatement.setInt(1,id);

         int row=preparedStatement.executeUpdate();
         if(row>0){
             System.out.println("Employee Deleted");
         }

        }catch (SQLException e){
         e.printStackTrace();
     }
    }
}
