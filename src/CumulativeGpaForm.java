import javax.swing.*;

public class CumulativeGpaForm {

    public void showForm(JPanel parentPanel, GenerateUI generateUI) {
        parentPanel.removeAll();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

        JTextField semestersField = new JTextField(5);
        parentPanel.add(new JLabel("Enter the number of semesters: "));
        parentPanel.add(semestersField);

        JTextField gpasField = new JTextField(20);
        parentPanel.add(new JLabel("Enter GPAs per semester (comma-separated):"));
        parentPanel.add(gpasField);

        JTextField creditHoursField = new JTextField(20);
        parentPanel.add(new JLabel("Enter total credit-hours per semester (comma-separated):"));
        parentPanel.add(creditHoursField);

        JButton submitBtn = new JButton("Calculate Cumulative GPA");
        submitBtn.addActionListener(e -> {
            int semesters = Integer.parseInt(semestersField.getText());
            double[] gpas = parseInput(gpasField.getText());
            double[] creditHours = parseInput(creditHoursField.getText());

            CumulativeGpaCalc cumulativeGpaCalc = new CumulativeGpaCalc();
            cumulativeGpaCalc.calculate(semesters, gpas, creditHours);
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
