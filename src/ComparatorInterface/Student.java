/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ComparatorInterface;

/**
 *
 * @author chris
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {

    private Integer id;
    private String name;

    // Constructor to initialize Student object
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = new ArrayList<>();

        // Populate the list with some examples
        students.add(new Student(1, "Charlie"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(3, "Alice"));
        

        // Print the original list
        System.out.println("Original list of students:");
        printStudents(students);

        // Define a comparator for sorting based on names
        Comparator<Student> NAME = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        // Sort the list of students based on names using the defined comparator
        Collections.sort(students, NAME);

        // Print the sorted list
        System.out.println("\nSorted list of students based on name:");
        printStudents(students);
    }

    // Helper method to print the list of students
    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("ID: " + student.id + ", Name: " + student.name);
        }
    }
}
