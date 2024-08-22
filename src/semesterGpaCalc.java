import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Scanner;

public class semesterGpaCalc implements gpaCalcInterface {
    private int classes;        // Stores the number of classes
    private double[] credits;   // Stores the number of credits for each class
    private double[] grades;    // Stores the grades for each class

    // HashMap to store grade boundaries and their corresponding GPA on a 4.0 scale
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

    // Method to set the number of classes
    @Override
    public int getClasses() {
        System.out.println("Enter the number of classes you are taking this semester: ");
        Scanner scanner = new Scanner(System.in);
        this.classes = scanner.nextInt();
        return this.classes;
    }

    // Method to set the number of credits for each class
    @Override
    public double[] getCredits() {
        System.out.println("Enter the number of credits for each class: ");
        Scanner scanner = new Scanner(System.in);
        this.credits = new double[this.classes];

        for (int i = 0; i < this.classes; i++) {
            this.credits[i] = scanner.nextDouble();
        }

        return this.credits;
    }

    // Method to set the grades for each class
    @Override
    public double[] getGrades() {
        System.out.println("Enter the grades for each class: ");
        Scanner scanner = new Scanner(System.in);
        this.grades = new double[this.classes];

        for (int i = 0; i < this.classes; i++) {
            this.grades[i] = scanner.nextDouble();
        }

        return this.grades;
    }

    // Method to convert the grades to a 4.0 scale
    @Override
    public double convertTo4Scale(double gpa) {
        int roundedGpa = (int) Math.round(gpa);

        // Use the TreeMap's floorEntry to find the nearest lower or equal boundary
        Map.Entry<Integer, Double> entry = gpaScaleMap.floorEntry(roundedGpa);
        if (entry != null) {
            return entry.getValue();
        }

        return 0.0; // Shouldn't reach here due to the map containing 0 key, but safe fallback
    }

    // Method to calculate the GPA using the stored values
    @Override
    public void calculate(int classes, double[] credits, double[] grades) {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 0; i < this.classes; i++) {
            totalCredits += this.credits[i];
            totalGradePoints += this.credits[i] * this.grades[i];
        }

        double gpa = totalGradePoints / totalCredits;

        double gpaOn4Scale = convertTo4Scale(gpa);
        System.out.println("Your GPA on a 4.0 scale is: " + gpaOn4Scale);
    }
}