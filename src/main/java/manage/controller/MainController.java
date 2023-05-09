package manage.controller;

import lombok.Getter;
import lombok.Setter;
import manage.model.MainConnection;
import manage.model.MainConnectionModel;
import manage.model.MainModel;
import manage.view.LoginView;
import manage.view.PizzaSelection;

@Getter
@Setter
public class MainController {
    private MainModel model;
    private LoginView login;
    private PizzaSelection pizzaSelection;
    private MainConnectionModel connectionModel;
    private MainConnection connection;
    private int currentOrderIndex;

    public MainController() {
        createAttributes();
        addListeners();
    }

    private void createAttributes() {
        model = new MainModel();
        login = new LoginView(model);
        connectionModel = new MainConnectionModel();
        connection = new MainConnection(connectionModel.getURL() + connectionModel.getDATABASE(), connectionModel.getUSERNAME(), connectionModel.getPASSWORD(), connectionModel.getDRIVER());
        pizzaSelection = new PizzaSelection(model, connection.getDefaultPizzas());
        currentOrderIndex = connection.getLatestOrderCode();
    }

    private void addListeners() {
        for (int i = 0; i < login.getButtons().size(); i++) {
            login.getButtons().get(i).addActionListener(new LoginListener(this));
        }
        pizzaSelection.getPizzasTable().getSelectionModel().addListSelectionListener(new PizzaSelectionListener(this));
        pizzaSelection.getFinishButton().addActionListener(new LoginListener(this));
    }
}
