package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        EmployeeDAO employeeDAO=new EmployeeDAO();

        int choice;

        do{
            System.out.println("Select your choice");

            System.out.println(" 1. Add Employee");
            System.out.println(" 2. View Employee");
            System.out.println(" 3. Update Employee");
            System.out.println(" 4. Delete Employee");
            System.out.println(" 5. Exit");

            choice=sc.nextInt();

            switch (choice){

                case 1:
                    sc.nextLine();
                    System.out.println("Enter Employee Name");
                    String name=sc.nextLine();

                    System.out.println("Enter Employee Department: ");
                    String dpt= sc.nextLine();

                    System.out.println("Enter Employee Salary");
                    int salary=sc.nextInt();

                    Employee employee=new Employee(name,dpt,salary);
                    employeeDAO.AddEmployee(employee);

                    break;
                case 2:
                    employeeDAO.ViewEmployee();
                    break;
                case 3:
                    System.out.println("Enter Id you want to Update");
                    int id=sc.nextInt();

//                    System.out.println("Enter Employee Department: ");
//                     dpt= sc.nextLine();

                    System.out.println("Enter Employee Salary");
                     salary=sc.nextInt();

                     employeeDAO.UpdateEmployee(id,salary);

                    break;
                case 4:
                    System.out.println("Enter Employee Id you want to Delete");
                     id=sc.nextInt();

                     employeeDAO.DeleteEmpolyee(id);
                    break;
                case 5: System.out.println(" Application closed");
                    break;
                default:System.out.println("Enter a valid choice");
            }
        }while(choice!=5);

        sc.close();
    }
}