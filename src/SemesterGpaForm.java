import javax.swing.*;

public class SemesterGpaForm {

    public void showForm() {
        JFrame formFrame = new JFrame("Enter Semester Details");
        formFrame.setSize(400, 300);
        formFrame.setLocationRelativeTo(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.PAGE_AXIS));

        JTextField classesField = new JTextField(5);
        formPanel.add(new JLabel("Enter the number of classes: "));
        formPanel.add(classesField);

        JTextField creditsField = new JTextField(20);
        formPanel.add(new JLabel("Enter credit-hours per class (comma-separated):"));
        formPanel.add(creditsField);

        JTextField gradesField = new JTextField(20);
        formPanel.add(new JLabel("Enter grades per class (comma-separated):"));
        formPanel.add(gradesField);

        JButton submitBtn = new JButton("Calculate GPA");
        submitBtn.addActionListener(e -> {
            int classes = Integer.parseInt(classesField.getText());
            double[] credits = parseInput(creditsField.getText());
            double[] grades = parseInput(gradesField.getText());

            SemesterGpaCalc semesterGpaCalc = new SemesterGpaCalc();
            semesterGpaCalc.calculate(classes, credits, grades);
        });

        formPanel.add(submitBtn);
        formFrame.add(formPanel);
        formFrame.setVisible(true);

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
