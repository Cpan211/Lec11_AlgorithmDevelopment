/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ComparableInterface;

/**
 *
 * @author chris
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {

    private Integer id;
    private String name;

    // Constructor to initialize Student object
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // CompareTo method for sorting based on student ID
    public int compareTo(Student s) {
        return id.compareTo(s.id);
    }

    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = new ArrayList<>();

        // Populate the list with some examples
        students.add(new Student(3, "Alice"));
        students.add(new Student(1, "Bob"));
        students.add(new Student(2, "Charlie"));

        // Print the original list
        System.out.println("Original list of students:");
        printStudents(students);

        // Sort the list of students based on their IDs
        Collections.sort(students);

        // Print the sorted list
        System.out.println("\nSorted list of students based on ID:");
        printStudents(students);
    }

    // Helper method to print the list of students
    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("ID: " + student.id + ", Name: " + student.name);
        }
    }
}
