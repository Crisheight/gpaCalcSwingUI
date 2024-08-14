public class semesterGpaCalc implements gpaCalcInterface {
    @Override
    public double[] getClasses() {
        return new double[0];
    }

    @Override
    public double[] getCredits() {
        return new double[0];
    }

    @Override
    public double[] getGrades() {
        return new double[0];
    }

    @Override
    public void calculate(double[] classes, double[] credits, double[] grades) {
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
