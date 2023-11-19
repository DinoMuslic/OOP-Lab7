package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

record Employee(int id, String name, double salary) {}

class EmployeeManagementSystem {
    public static List<Employee> filterEmployeesBySalary(List<Employee> employees, double minSalary) {
        return employees.stream().
                filter(e -> e.salary() >= minSalary).
                collect(Collectors.toList());
    }

    public static double calculateTotalSalary(List<Employee> employees) {
        double totalSalary = 0;
        for(Employee e : employees) {
            totalSalary += e.salary();
        }
        return totalSalary;
    }

    public static void displayEmployeeDetails(List<Employee> employees) {
        for(Employee e : employees) {
            System.out.println(e);
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Dino", 505.55));
        employees.add(new Employee(2, "Armin", 305));
        employees.add(new Employee(3, "Idris", 10.25));
        employees.add(new Employee(4, "Mirza", 1002.55));
        employees.add(new Employee(5, "Riki", 555.55));
        employees.add(new Employee(6, "Ensar", 500));

        System.out.println(EmployeeManagementSystem.filterEmployeesBySalary(employees, 550));

        System.out.println(EmployeeManagementSystem.calculateTotalSalary(employees));

        EmployeeManagementSystem.displayEmployeeDetails(employees);
    }
}
