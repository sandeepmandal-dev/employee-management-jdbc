package com.example;
import java.sql.*;

public class EmployeeDAO {

 public void AddEmployee(Employee employee){
     String checkQuery="select * from employees where id =?";
     String sqlQuery="Insert into employees(id,name,department,salary) values(?,?,?,?)";

     try(Connection connection=DBConnection.getConnection()){
         PreparedStatement checkStatement=connection.prepareStatement(checkQuery);
         checkStatement.setInt(1,employee.getId());
         ResultSet resultSet=checkStatement.executeQuery();
         if(resultSet.next()){
             System.out.println("Employee id Already exist");
         }
        else{
             PreparedStatement insertStatement=connection.prepareStatement(sqlQuery);
             insertStatement.setInt(1, employee.getId());
             insertStatement.setString(2, employee.getName());
             insertStatement.setString(3, employee.getDepartment());
             insertStatement.setInt(4, employee.getSalary());

             int row = insertStatement.executeUpdate();

             if (row > 0) {
                 System.out.println("Employee Added");
             }
         }
     }catch (SQLException e){
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

    public void updateName(int id, String newName) {
     String updateNameQuery="UPDATE employees SET name=? WHERE id=?";

     try (Connection connection=DBConnection.getConnection();
          PreparedStatement preparedStatement=connection.prepareStatement(updateNameQuery)){

         preparedStatement.setString(1, newName);
         preparedStatement.setInt(2, id);

         int rows = preparedStatement.executeUpdate();

         if (rows > 0) {
             System.out.println("Name Updated Successfully");
         } else {
             System.out.println("Employee ID Not Found");
         }

     }catch (SQLException e){
         e.printStackTrace();
     }
    }

    public void updateDepartment(int id, String dept) {
        String query = "UPDATE employees SET department=? WHERE id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, dept);
            preparedStatement.setInt(2, id);

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Department Updated Successfully");
            } else {
                System.out.println("Employee ID Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSalary(int id, int salary) {

        String query = "UPDATE employees SET salary=? WHERE id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, salary);
            preparedStatement.setInt(2, id);

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Salary Updated Successfully");
            } else {
                System.out.println("Employee ID Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAll(int id, String name, String dept, int salary) {
        String query = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, dept);
            preparedStatement.setInt(3, salary);
            preparedStatement.setInt(4, id);

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Updated Successfully");
            } else {
                System.out.println("Employee ID Not Found");
            }

        } catch (SQLException e) {
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
         }else{
             System.out.println("Employee ID Not Present");
         }
        }catch (SQLException e){
         e.printStackTrace();
     }
    }
}
