Q1. Write a program to sort a list of Employee objects (name, age, salary) using lambda expressions.     
  

import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        // Creating a list of Employee objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("A", 30, 50000));
        employees.add(new Employee("B", 28, 60000));
        employees.add(new Employee("C", 35, 45000));
        employees.add(new Employee("D", 25, 70000));

        // Sorting employees by name
        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Employees sorted by name: " + employees);

        // Sorting employees by age
        employees.sort((e1, e2) -> Integer.compare(e1.age, e2.age));
        System.out.println("Employees sorted by age: " + employees);

        // Sorting employees by salary
        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));
        System.out.println("Employees sorted by salary: " + employees);
    }
}


OUTPUT:

Employees sorted by name: [Employee{name='B', age=28, salary=60000.0}, Employee{name='C', age=35, salary=45000.0}, Employee{name='D', age=25, salary=70000.0}, Employee{name='A', age=30, salary=50000.0}]
Employees sorted by age: [Employee{name='D', age=25, salary=70000.0}, Employee{name='B', age=28, salary=60000.0}, Employee{name='A', age=30, salary=50000.0}, Employee{name='C', age=35, salary=45000.0}]
Employees sorted by salary: [Employee{name='C', age=35, salary=45000.0}, Employee{name='A', age=30, salary=50000.0}, Employee{name='B', age=28, salary=60000.0}, Employee{name='D', age=25, salary=70000.0}]

