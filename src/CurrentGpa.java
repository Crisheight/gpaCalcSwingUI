public class CurrentGpa {

    private static CurrentGpa instance;
    private double currentGpa;

    // Private constructor to enforce singleton pattern
    private CurrentGpa() {
        this.currentGpa = 0.0; // Default value
    }

    // Public method to get the instance of CurrentGpa
    public static CurrentGpa getInstance() {
        if (instance == null) {
            instance = new CurrentGpa();
        }
        return instance;
    }

    // Method to set the current GPA
    public void setCurrentGpa(double gpa) {
        this.currentGpa = gpa;
    }

    // Method to get the current GPA
    public double getCurrentGpa() {
        return this.currentGpa;
    }
}
