import javax.swing.*;
import java.util.*;

public class SemesterGpaCalc {
    // TreeMap to store grade boundaries and their corresponding GPA on a 4.0 scale
    private static final NavigableMap<Integer, Double> gpaScaleMap = new TreeMap<>();

    // Static block to initialize the gpaScaleMap
    static {
        gpaScaleMap.put(97, 4.3);
        gpaScaleMap.put(93, 4.0);
        gpaScaleMap.put(90, 3.7);
        gpaScaleMap.put(87, 3.3);
        gpaScaleMap.put(83, 3.0);
        gpaScaleMap.put(80, 2.7);
        gpaScaleMap.put(77, 2.3);
        gpaScaleMap.put(73, 2.0);
        gpaScaleMap.put(70, 1.7);
        gpaScaleMap.put(67, 1.3);
        gpaScaleMap.put(63, 1.0);
        gpaScaleMap.put(60, 0.7);
        gpaScaleMap.put(0, 0.0);  // Default for F grade
    }

    // Method to convert the grades to a 4.0 scale
    public double convertTo4Scale(double gpa) {
        int roundedGpa = (int) Math.round(gpa);

        // Use the TreeMap's floorEntry to find the nearest lower or equal boundary
        Map.Entry<Integer, Double> entry = gpaScaleMap.floorEntry(roundedGpa);
        if (entry != null) {
            return entry.getValue();
        }

        return 0.0; // Shouldn't reach here due to the map containing 0 key, but safe fallback
    }

    // Method to calculate the GPA using the provided values
    public void calculate(int classes, double[] credits, double[] grades) {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 0; i < classes; i++) {
            totalCredits += credits[i];
            totalGradePoints += credits[i] * grades[i];
        }

        double gpa = totalGradePoints / totalCredits;

        double gpaOn4Scale = convertTo4Scale(gpa);
        JOptionPane.showMessageDialog(
                null, "Your GPA on a 4.0 scale is: " + gpaOn4Scale,
                "GPA Result", JOptionPane.INFORMATION_MESSAGE);
    }
}