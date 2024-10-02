import javax.swing.*;

public class FutureGpaCalc {

    // Method to calculate the required GPA for additional credits
    public double calculate(Double currentGpaInput, int currentCredits, double goalGpa, int additionalCredits) {
        // If the user provides a valid current GPA input, use it. Otherwise, fall back to the CurrentGpa singleton value.
        double currentGpa = (currentGpaInput != null && currentGpaInput >= 0.0) ? currentGpaInput : CurrentGpa.getInstance().getCurrentGpa();

        // Formula: targetGpa = (currentGpa * currentCredits + goalGpa * additionalCredits) / (currentCredits + additionalCredits)
        double totalCredits = currentCredits + additionalCredits;
        double totalPoints = (currentGpa * currentCredits) + (goalGpa * additionalCredits);
        double targetGpa = totalPoints / totalCredits;

        // Round to two decimal places
        targetGpa = Math.round(targetGpa * 100.0) / 100.0;

        // Display the calculated target GPA
        JOptionPane.showMessageDialog(
                null, "Your required GPA for additional credits is: " + targetGpa,
                "Target GPA Result", JOptionPane.INFORMATION_MESSAGE);

        return targetGpa;
    }
}
