package student_database;

import java.util.*;

public class Student {

    private int studentID;

    private String Name;

    private int Roll_No;

    private int[] marks;

    private double grade;

    public Student(int Roll_No, String Name, int[] marks) {

        this.Roll_No = Roll_No;

        this.Name = Name;

        this.marks = marks;

        this.grade = CalculateGrade();

    }

    private double CalculateGrade() {

        int totalmarks = 0;

        for (int i = 0; i < marks.length; i++) {

            totalmarks += marks[i];

        }

        double percentage = totalmarks / 5.0; // Fixed integer division issue

        return percentage / 10;

    }

    public boolean topstudent() {

        return grade >= 8;

    }

    public void updateStudent(String newName, int[] newMarks) {

        this.Name = newName;

        this.marks = newMarks;

        this.grade = CalculateGrade();

    }

    public int getRollNo() {

        return Roll_No;

    }

    public double getGrade() {

        return grade;

    }


    @Override

    public String toString() {

        return "Roll No: " + Roll_No + ", Name: " + Name + ", Grade: " + grade;

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");

        int numStudents = scanner.nextInt();



        Student[] students = new Student[numStudents];



        // Accept student details

        for (int i = 0; i < numStudents; i++) {

            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Enter Roll No: ");

            int rollNo = scanner.nextInt();

            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");

            String name = scanner.nextLine();

            int[] marks = new int[5];

            System.out.println("Enter 5 subject marks:");

            for (int j = 0; j < 5; j++) {

                marks[j] = scanner.nextInt();

            }

            students[i] = new Student(rollNo, name, marks);

        }



        while (true) {

            System.out.println("\nMenu:");

            System.out.println("1. Display all students");

            System.out.println("2. Update a student's details");

            System.out.println("3. Display a particular student by Roll No");

            System.out.println("4. Display top 5 students");

            System.out.println("5. Find grade of all students");

            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();



            switch (choice) {

                case 1:

                    System.out.println("\nStudent Details:");

                    for (Student s : students) {

                        System.out.println(s);

                    }

                    break;



                case 2:

                    System.out.print("\nEnter Roll No to update: ");

                    int rollNoToUpdate = scanner.nextInt();

                    boolean found = false;

                    for (Student s : students) {

                        if (s.getRollNo() == rollNoToUpdate) {

                            scanner.nextLine(); // Consume newline

                            System.out.print("Enter new Name: ");

                            String newName = scanner.nextLine();

                            int[] newMarks = new int[5];

                            System.out.println("Enter new 5 subject marks:");

                            for (int j = 0; j < 5; j++) {

                                newMarks[j] = scanner.nextInt();

                            }

                            s.updateStudent(newName, newMarks);

                            System.out.println("Student details updated!");

                            found = true;

                            break;

                        }

                    }

                    if (!found) System.out.println("Student not found!");

                    break;



                case 3:

                    System.out.print("\nEnter Roll No to display: ");

                    int rollNoToFind = scanner.nextInt();

                    boolean foundStudent = false;

                    for (Student s : students) {

                        if (s.getRollNo() == rollNoToFind) {

                            System.out.println(s);

                            foundStudent = true;

                            break;

                        }

                    }

                    if (!foundStudent) System.out.println("Student not found!");

                    break;



                case 4:

                    System.out.println("\nTop 5 Students:");

                    Arrays.sort(students, (a, b) -> Double.compare(b.getGrade(), a.getGrade())); // Sort by grade

                    for (int i = 0; i < Math.min(5, students.length); i++) {

                        System.out.println(students[i]);

                    }

                    break;



                case 5:

                    System.out.println("\nGrades of all students:");

                    for (Student s : students) {

                        System.out.println("Roll No: " + s.getRollNo() + ", Grade: " + s.getGrade());

                    }

                    break;



                case 6:

                    System.out.println("Exiting...");

                    scanner.close();

                    return;



                default:

                    System.out.println("Invalid choice! Try again.");

            }

        }

    }

}

