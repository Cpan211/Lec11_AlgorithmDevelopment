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
    private Double gpa;
    private Integer age;
    private String major;
    
    // Constructor to initialize Student object
    public Student(int id, String name, double gpa, int age, String major) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.age = age;
        this.major = major;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public Integer getId() {
        return id;
    }
    
    public Double getGpa() {
        return gpa;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public String getMajor() {
        return major;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, GPA: %.2f, Age: %d, Major: %s", 
                           id, name, gpa, age, major);
    }
    
    public static void main(String[] args) {
        // Create a list of Student objects with more diverse data
        List<Student> students = new ArrayList<>();
        students.add(new Student(105, "Charlie", 3.2, 20, "Computer Science"));
        students.add(new Student(102, "Bob", 3.8, 22, "Mathematics"));
        students.add(new Student(103, "Alice", 3.9, 19, "Computer Science"));
        students.add(new Student(101, "Diana", 3.5, 21, "Physics"));
        students.add(new Student(104, "Eve", 3.8, 20, "Mathematics"));
        students.add(new Student(106, "Frank", 2.9, 23, "Physics"));
        
        System.out.println("=== ORIGINAL LIST ===");
        printStudents(students);
        
        // 1. SIMPLE COMPARISONS - Single attribute sorting
        
        // Sort by name (alphabetical)
        Comparator<Student> byName = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };
        
        // Sort by ID
        Comparator<Student> byId = (s1, s2) -> s1.getId().compareTo(s2.getId());
        
        // Sort by GPA (descending - highest first)
        Comparator<Student> byGpaDesc = (s1, s2) -> s2.getGpa().compareTo(s1.getGpa());
        
        // Sort by age
        Comparator<Student> byAge = Comparator.comparing(Student::getAge);
        
        // Demonstrate simple comparisons
        System.out.println("\n=== SIMPLE COMPARISONS ===");
        
        Collections.sort(students, byName);
        System.out.println("\nSorted by Name (A-Z):");
        printStudents(students);
        
        Collections.sort(students, byId);
        System.out.println("\nSorted by ID:");
        printStudents(students);
        
        Collections.sort(students, byGpaDesc);
        System.out.println("\nSorted by GPA (Highest first):");
        printStudents(students);
        
        Collections.sort(students, byAge);
        System.out.println("\nSorted by Age:");
        printStudents(students);
        
        // 2. COMBINED COMPARISONS - Multiple attribute sorting
        
        System.out.println("\n=== COMBINED COMPARISONS ===");
        
        // Sort by Major first, then by GPA (descending) within each major
        Comparator<Student> byMajorThenGpa = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // First compare by major
                int majorComparison = s1.getMajor().compareTo(s2.getMajor());
                if (majorComparison != 0) {
                    return majorComparison;
                }
                // If majors are the same, compare by GPA (descending)
                return s2.getGpa().compareTo(s1.getGpa());
            }
        };
        
        Collections.sort(students, byMajorThenGpa);
        System.out.println("\nSorted by Major, then GPA (highest within each major):");
        printStudents(students);

      
        
        // 3. CUSTOM COMPARISON LOGIC
        
        System.out.println("\n=== CUSTOM COMPARISON LOGIC ===");
        
        // Custom comparator: Students with GPA >= 3.5 come first, 
        // then sorted by age within each group
        Comparator<Student> honorStudentsFirst = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                boolean s1Honor = s1.getGpa() >= 3.5;
                boolean s2Honor = s2.getGpa() >= 3.5;
                
                if (s1Honor && !s2Honor) {
                    return -1; // s1 comes first
                } else if (!s1Honor && s2Honor) {
                    return 1;  // s2 comes first
                } else {
                    // Both are honor students or both are not, sort by age
                    return s1.getAge().compareTo(s2.getAge());
                }
            }
        };
        
        Collections.sort(students, honorStudentsFirst);
        System.out.println("\nHonor Students (GPA ≥ 3.5) first, then by age:");
        printStudents(students);
        
        // 4. USING STATIC NESTED CLASS COMPARATOR
        
        Collections.sort(students, new StudentIdComparator());
        System.out.println("\nSorted using static nested class (by ID):");
        printStudents(students);
    }
    
    // Helper method to print the list of students
    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    // Static nested class implementing Comparator
    private static class StudentIdComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getId().compareTo(s2.getId());
        }
    }
    
    // Additional example: Age-based comparator as static nested class
    private static class StudentAgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getAge().compareTo(s2.getAge());
        }
    }
}
