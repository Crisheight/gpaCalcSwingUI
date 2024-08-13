import javax.swing.*;

public class generateUI {

    public void createUI() {
        JFrame frame = new JFrame("GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JButton option1Btn = new JButton("Calculate Semester GPA");
        JButton option2Btn = new JButton("Calculate Cumulative GPA");
        JButton option3Btn = new JButton("Calculate Future GPA");
        JButton option4Btn = new JButton("Show Current GPA");

        panel.add(option1Btn);
        panel.add(option2Btn);
        panel.add(option3Btn);
        panel.add(option4Btn);

        frame.add(panel);
    }


} // End Class generateUI
