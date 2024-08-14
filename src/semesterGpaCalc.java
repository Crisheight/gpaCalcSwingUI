public class semesterGpaCalc implements gpaCalcInterface {
    public void calculate(double[] grades, double[] credits) {
        double totalCredits = 0;
        double totalGradePoints = 0;
        double gpa;

        for (int i = 0; i < grades.length; i++) {
            totalCredits += credits[i];
            totalGradePoints += grades[i] * credits[i];
        }

        gpa = totalGradePoints / totalCredits;

        System.out.println("Semester GPA: " + gpa);
    }
}
