package Week3.Task1;

import java.util.*;

//task 2 : write a java program to accept the students name and marks in subjects and find the total and average of the  marks and sort the list accordingly
public class _2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<_2Student> students = new ArrayList<>();

            System.out.print("Enter the number of students: ");
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter the name of student " + (i + 1) + ": ");
                String name = scanner.nextLine();

                System.out.print("Enter the number of subjects for " + name + ": ");
                int numberOfSubjects = scanner.nextInt();
                int[] marks = new int[numberOfSubjects];

                for (int j = 0; j < numberOfSubjects; j++) {
                    System.out.print("Enter the marks for subject " + (j + 1) + ": ");
                    marks[j] = scanner.nextInt();
                }
                scanner.nextLine(); // Consume newline

                students.add(new _2Student(name, marks));
            }
            Collections.sort(students,Comparator.comparingDouble(_2Student::getAverage).reversed());
            for(_2Student stu:students)
            {System.out.println(stu .getName()+"  "+stu .getAverage()) ;
        }

    }}


