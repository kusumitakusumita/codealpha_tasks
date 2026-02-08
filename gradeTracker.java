package codealpha_tasks;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class gradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Summary Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayReport();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student grade: ");
        int grade = sc.nextInt();

        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    static void displayReport() {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        int total = 0;
        int highest = students.get(0).grade;
        int lowest = students.get(0).grade;

        System.out.println("\n--- Student Summary Report ---");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Grade: " + s.grade);
            total += s.grade;
            if (s.grade > highest) highest = s.grade;
            if (s.grade < lowest) lowest = s.grade;
        }

        double average = (double) total / students.size();

        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}
