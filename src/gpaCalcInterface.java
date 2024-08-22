public interface gpaCalcInterface {
    int getClasses();
    double[] getCredits();
    double[] getGrades();
    double convertTo4Scale(double gpa);
    void calculate(int classes, double[] credits, double[] grades);
}
