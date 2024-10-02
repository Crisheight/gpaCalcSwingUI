import javax.swing.*;

public class CurrentGpaForm {

    public void showForm(JPanel parentPanel, GenerateUI generateUI) {
        parentPanel.removeAll();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

        // Get the current GPA from the CurrentGpa class
        double currentGpa = CurrentGpa.getInstance().getCurrentGpa();

        // Display the current GPA
        JOptionPane.showMessageDialog(
                null, "Your current GPA is: " + currentGpa,
                "Current GPA", JOptionPane.INFORMATION_MESSAGE);

        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener(e -> generateUI.addOptionButtons());

        parentPanel.add(homeBtn);
        parentPanel.revalidate();
        parentPanel.repaint();
    }
}
