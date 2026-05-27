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

                case 1://Add Employee
                    System.out.println("Enter Employee Id");
                    int EId=sc.nextInt();

                    sc.nextLine();
                    System.out.println("Enter Employee Name");
                    String name=sc.nextLine();

                    System.out.println("Enter Employee Department: ");
                    String dpt= sc.nextLine();

                    System.out.println("Enter Employee Salary");
                    int salary=sc.nextInt();

                    Employee employee=new Employee(EId,name,dpt,salary);
                    employeeDAO.AddEmployee(employee);

                    break;
                case 2://View Employee
                    employeeDAO.ViewEmployee();
                    break;
                case 3://Update Employee
                    System.out.println("Enter Id you want to Update");
                    int id=sc.nextInt();

                    System.out.println(" \n What do you want to update?");
                    System.out.println("1. Name");
                    System.out.println("2. Department");
                    System.out.println("3. Salary");
                    System.out.println("4. All");

                    System.out.print("Enter Choice: ");
                    int updateChoice=sc.nextInt();

                    sc.nextLine();

                    switch (updateChoice) {

                        case 1:

                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();

                            employeeDAO.updateName(id, newName);

                            break;

                        case 2:

                            System.out.print("Enter New Department: ");
                            String newDept = sc.nextLine();

                            employeeDAO.updateDepartment(id, newDept);

                            break;

                        case 3:

                            System.out.print("Enter New Salary: ");
                            int newSalary = sc.nextInt();

                            employeeDAO.updateSalary(id, newSalary);

                            break;

                        case 4:

                            System.out.print("Enter New Name: ");
                             name = sc.nextLine();

                            System.out.print("Enter New Department: ");
                            String dept = sc.nextLine();

                            System.out.print("Enter New Salary: ");
                             salary = sc.nextInt();

                            employeeDAO.updateAll(id, name, dept, salary);

                            break;

                        default:

                            System.out.println("Invalid Choice");
                    }
                    break;
                case 4: //Delete Employee
                    System.out.println("Enter Employee Id you want to Delete");
                     id=sc.nextInt();

                     employeeDAO.DeleteEmpolyee(id);
                    break;

                    //Exit
                case 5: System.out.println(" Application closed");
                    break;
                default:System.out.println("Enter a valid choice");
            }
        }while(choice!=5);

        sc.close();
    }
}