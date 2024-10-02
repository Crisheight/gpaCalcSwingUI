import javax.swing.*;

public class FutureGpaForm {

    public void showForm(JPanel parentPanel, GenerateUI generateUI) {
        parentPanel.removeAll();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

        // Input fields for target GPA calculation
        JTextField currentGpaField = new JTextField(5);
        parentPanel.add(new JLabel("Enter your current GPA: (leave blank to use last known GPA)"));
        parentPanel.add(currentGpaField);

        JTextField currentCreditsField = new JTextField(5);
        parentPanel.add(new JLabel("Enter your current credits: "));
        parentPanel.add(currentCreditsField);

        JTextField goalGpaField = new JTextField(5);
        parentPanel.add(new JLabel("Enter your goal GPA: "));
        parentPanel.add(goalGpaField);

        JTextField additionalCreditsField = new JTextField(5);
        parentPanel.add(new JLabel("Enter the additional credits: "));
        parentPanel.add(additionalCreditsField);

        JButton submitBtn = new JButton("Calculate Target GPA");
        submitBtn.addActionListener(e -> {
            // Handle current GPA input
            Double currentGpaInput = null;
            String currentGpaText = currentGpaField.getText();
            if (!currentGpaText.isEmpty()) {
                currentGpaInput = Double.parseDouble(currentGpaText);
            }

            int currentCredits = Integer.parseInt(currentCreditsField.getText());
            double goalGpa = Double.parseDouble(goalGpaField.getText());
            int additionalCredits = Integer.parseInt(additionalCreditsField.getText());

            FutureGpaCalc futureGpaCalc = new FutureGpaCalc();
            double targetGpa = futureGpaCalc.calculate(currentGpaInput, currentCredits, goalGpa, additionalCredits);

            // Update current GPA with the target GPA result
            CurrentGpa.getInstance().setCurrentGpa(targetGpa);
        });

        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener(e -> generateUI.addOptionButtons());

        parentPanel.add(submitBtn);
        parentPanel.add(homeBtn);
        parentPanel.revalidate();
        parentPanel.repaint();
    }
}
