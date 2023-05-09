package manage.view;

import lombok.Getter;
import lombok.Setter;
import manage.model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class LoginView extends JFrame {

private JTextField numberLabel;
    private JPasswordField passwordField;
    private ArrayList<JButton> buttons;
    private ArrayList<JLabel> labels;
    public LoginView(MainModel model) {
        createAddAttributes(model);
        setAttributes(model.getLoginTexts().get(0));
    }

    private void createAddAttributes(MainModel model) {
        JPanel panel = new JPanel(new FlowLayout());
        labels = new ArrayList<>();
        for (int i = 0; i < model.getLabelTexts().size(); i++) {
            labels.add(new JLabel(model.getLabelTexts().get(i)));
        }
        labels.add(new JLabel());
        numberLabel = new JTextField(11);
        passwordField = new JPasswordField(11);

        panel.add(labels.get(0));
        panel.add(labels.get(1));
        panel.add(numberLabel);
        panel.add(labels.get(2));
        panel.add(passwordField);
        buttons = new ArrayList<>();
        for (int i = 0; i < model.getButtonTexts().size(); i++) {
            buttons.add(new JButton(model.getButtonTexts().get(i)));
            panel.add(buttons.get(i));
        }
        panel.add(labels.get(labels.size() - 1));
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
