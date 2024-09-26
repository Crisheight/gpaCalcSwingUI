import javax.swing.*;
import java.awt.*;

public class CumulativeGpaForm {

    public void showForm(JPanel parentPanel, GenerateUI generateUI) {
        parentPanel.removeAll();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

        JTextField termField = new JTextField(5);
        parentPanel.add(new JLabel("Enter the number of terms: "));
        parentPanel.add(termField);

        JTextField classesField = new JTextField(5);
        parentPanel.add(new JLabel("Enter the number of classes per term: "));
        parentPanel.add(classesField);

        JTextField creditsField = new JTextField(20);
        parentPanel.add(new JLabel("Enter credit-hours per class (comma-separated):"));
        parentPanel.add(creditsField);

        JTextField gradesField = new JTextField(20);
        parentPanel.add(new JLabel("Enter grades per class (comma-separated):"));
        parentPanel.add(gradesField);

        JButton submitBtn = new JButton("Calculate GPA");
        submitBtn.addActionListener(e -> {
            int classes = Integer.parseInt(classesField.getText());
            double[] credits = parseInput(creditsField.getText());
            double[] grades = parseInput(gradesField.getText());

            SemesterGpaCalc semesterGpaCalc = new SemesterGpaCalc();
            semesterGpaCalc.calculate(classes, credits, grades);
        });

        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener(e -> generateUI.addOptionButtons());

        parentPanel.add(submitBtn);
        parentPanel.add(homeBtn);
        parentPanel.revalidate();
        parentPanel.repaint();
    }

    private double[] parseInput(String input) {
        String[] parts = input.split(",");
        double[] values = new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Double.parseDouble(parts[i].trim());
        }
        return values;
    }
}
