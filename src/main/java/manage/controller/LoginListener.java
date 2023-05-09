package manage.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private MainController controller;

    public LoginListener(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controller.getLogin().getButtons().get(0)) {
            int client_number = Integer.parseInt(controller.getLogin().getNumberLabel().getText());
            String password = controller.getLogin().getPasswordField().getText();
            if (!controller.getConnection().checkLogin(client_number, password)) {
                controller.getLogin().getLabels().get(controller.getLogin().getLabels().size() - 1).setText(controller.getModel().getMessages().get(1));
            } else {
                controller.getLogin().setVisible(false);
                controller.getPizzaSelection().setVisible(true);
                controller.getConnection().createOrder(client_number);
                controller.setCurrentOrderIndex(controller.getCurrentOrderIndex() + 1);
            }
        } else if (e.getSource() == controller.getLogin().getButtons().get(1)) {
            int client_number = Integer.parseInt(controller.getLogin().getNumberLabel().getText());
            String password = controller.getLogin().getPasswordField().getText();
            if (controller.getConnection().checkIfClientExists(client_number)) {
                controller.getLogin().getLabels().get(controller.getLogin().getLabels().size() - 1).setText(controller.getModel().getMessages().get(0));
            } else {
                controller.setCurrentOrderIndex(controller.getCurrentOrderIndex() + 1);
                controller.getConnection().createOrderAndClient(client_number, password);

                controller.getLogin().setVisible(false);
                controller.getPizzaSelection().setVisible(true);
            }
        } else {
            System.exit(0);
        }
    }
}
