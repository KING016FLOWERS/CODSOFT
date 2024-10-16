/*
Poovarasan H
Java Programming Intern
*/
package StudentGradeCalculator.src;
import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        // Array to store marks of each subject
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        
        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
        
        // Calculate the average percentage
        double avg = (double) totalMarks / numSubjects;
        
        // Assign grade based on average percentage
        char grade;
        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        } else {
            grade = 'F'; // Fail
        }
        
        // Display results
        System.out.println("\nTotal Marks: " + totalMarks+"/"+numSubjects*100);
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
