import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Create a new instance of the generateUI class
        SwingUtilities.invokeLater(() -> new generateUI().createUI());

    }
}