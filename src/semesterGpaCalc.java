import java.util.Scanner;

public class semesterGpaCalc implements gpaCalcInterface {
    @Override
    public double getClasses() {
        System.out.println("Enter the number of classes you are taking this semester: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public double[] getCredits() {
        System.out.println("Enter the number of credits for each class: ");
        Scanner scanner = new Scanner(System.in);
        double[] credits = new double[(int) getClasses()];

        for (int i = 0; i < credits.length; i++) {
            credits[i] = scanner.nextDouble();
        }

        return credits;
    }

    @Override
    public double[] getGrades() {
        System.out.println("Enter the grades for each class: ");
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[(int) getClasses()];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = scanner.nextDouble();
        }

        return grades;
    }

    @Override
    public void calculate(int classes, double[] credits, double[] grades) {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 0; i < classes; i++) {
            totalCredits += credits[i];
            totalGradePoints += credits[i] * grades[i];
        }

        double gpa = totalGradePoints / totalCredits;
        System.out.println("Your semester GPA is: " + gpa);
    }
}
