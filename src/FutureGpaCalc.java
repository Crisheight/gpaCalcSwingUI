import javax.swing.*;

public class FutureGpaCalc {

    // Method to calculate the required GPA for additional credits
    public double calculate(Double currentGpaInput, int currentCredits, double goalGpa, int additionalCredits) {
        // If the user provides a valid current GPA input, use it. Otherwise, fall back to the CurrentGpa singleton value.
        double currentGpa = (currentGpaInput != null && currentGpaInput >= 0.0) ? currentGpaInput : CurrentGpa.getInstance().getCurrentGpa();

        // Rearranged formula to calculate the required GPA for additional credits to achieve the goal GPA
        double requiredGpa = ((goalGpa * (currentCredits + additionalCredits)) - (currentGpa * currentCredits)) / additionalCredits;

        // Round to two decimal places
        requiredGpa = Math.round(requiredGpa * 100.0) / 100.0;

        // Display the required GPA for additional credits
        JOptionPane.showMessageDialog(
                null, "You need a GPA of: " + requiredGpa + " in your additional credits to achieve your goal GPA of " + goalGpa,
                "Required GPA Result", JOptionPane.INFORMATION_MESSAGE);

        return requiredGpa;
    }
}
