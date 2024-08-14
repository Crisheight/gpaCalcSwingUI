public interface gpaCalcInterface {
    double[] getClasses();
    double[] getCredits();
    double[] getGrades();
    void calculate(double[] classes, double[] credits, double[] grades);
}
