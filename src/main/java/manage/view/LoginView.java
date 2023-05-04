package manage.view;

import manage.model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginView extends JFrame {
    private JTextField numberLabel;
    private JPasswordField passwordField;
    private JButton submitButton;

    public LoginView(MainModel model) {
        createAddAttributes(model);
        setAttributes(model.getLoginTexts().get(0));
    }

    private void createAddAttributes(MainModel model) {
        JPanel panel = new JPanel(new FlowLayout());
        ArrayList<JLabel> labels = new ArrayList<>();
        for (int i = 0; i < model.getLabelTexts().size(); i++) {
            labels.add(new JLabel(model.getLabelTexts().get(i)));
        }
        numberLabel = new JTextField(11);
        passwordField = new JPasswordField(11);
        submitButton = new JButton(model.getLoginTexts().get(1));
        panel.add(labels.get(0));
        panel.add(labels.get(1));
        panel.add(numberLabel);
        panel.add(labels.get(2));
        panel.add(passwordField);
        panel.add(submitButton);
        add(panel);
    }

    private void setAttributes(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
