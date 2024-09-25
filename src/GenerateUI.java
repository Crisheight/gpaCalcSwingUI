import javax.swing.*;
import java.awt.*;

public class GenerateUI {

    private JPanel panel;

    public void createUI() {
        JFrame frame = new JFrame("GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 400);
        frame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        addOptionButtons();

        JPanel panelHolder = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        panelHolder.add(panel, gbc);
        frame.add(panelHolder);
    }

    public void addOptionButtons() {
        panel.removeAll();

        JButton option1Btn = new JButton("Calculate Semester GPA");
        JButton option2Btn = new JButton("Calculate Cumulative GPA");
        JButton option3Btn = new JButton("Calculate Future GPA");
        JButton option4Btn = new JButton("Show Current GPA");

        option1Btn.addActionListener(e -> {
            SemesterGpaForm semesterGpaForm = new SemesterGpaForm();
            semesterGpaForm.showForm(panel, this);
        });

        panel.add(option1Btn);
        panel.add(option2Btn);
        panel.add(option3Btn);
        panel.add(option4Btn);

        panel.revalidate();
        panel.repaint();
    }

}