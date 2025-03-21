Q2. Create a program to use lambda expressions and stream operations to filter students scoring above 75%, sort them by marks, and display their names.

import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + '}';
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        // Creating a list of students with names A, B, C
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", 85));
        students.add(new Student("B", 72));
        students.add(new Student("C", 90));
        students.add(new Student("D", 60));
        students.add(new Student("E", 78));

        // Use streams to filter students scoring above 75%, sort them by marks, and display their names
        students.stream()
                .filter(s -> s.marks > 75)  // Filter students scoring above 75%
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))  // Sort by marks in descending order
                .forEach(s -> System.out.println(s.name));  // Display the names
    }
}

OUTPUT:

C
A
E
