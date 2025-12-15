package com.skillnext1;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        try {
            while (true) {
                System.out.println("\n===== EMPLOYEE MENU =====");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        Employee emp = new Employee(name, email, salary);
                        dao.addEmployee(emp);
                        System.out.println("Employee added successfully!");
                        break;

                    case 2:
                        List<Employee> list = dao.getAllEmployees();
                        for (Employee e : list) {
                            System.out.println(e);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New Name: ");
                        String nname = sc.nextLine();

                        System.out.print("New Email: ");
                        String nemail = sc.nextLine();

                        System.out.print("New Salary: ");
                        double nsal = sc.nextDouble();

                        Employee uemp = new Employee(uid, nname, nemail, nsal);
                        dao.updateEmployee(uemp);
                        System.out.println("Employee updated!");
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to delete: ");
                        int did = sc.nextInt();
                        dao.deleteEmployee(did);
                        System.out.println("Employee deleted!");
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
