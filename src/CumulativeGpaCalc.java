import javax.swing.*;

public class CumulativeGpaCalc {

    // Method to calculate the cumulative GPA
    public void calculate(int semesters, double[] gpas, double[] creditHours) {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 0; i < semesters; i++) {
            totalCredits += creditHours[i];
            totalGradePoints += gpas[i] * creditHours[i];
        }

        double cumulativeGpa = totalGradePoints / totalCredits;
        cumulativeGpa = Math.round(cumulativeGpa * 100.0) / 100.0;

        JOptionPane.showMessageDialog(
                null, "Your Cumulative GPA is: " + cumulativeGpa,
                "Cumulative GPA Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
