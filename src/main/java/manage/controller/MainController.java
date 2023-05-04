package manage.controller;

import manage.model.MainConnection;
import manage.model.MainConnectionModel;
import manage.model.MainModel;
import manage.model.dbentities.Order;
import manage.view.LoginView;

import java.util.ArrayList;

public class MainController {
    private MainModel model;
    private LoginView login;
    private MainConnectionModel connectionModel;
    private MainConnection connection;
    private ArrayList<Order> orders;

    public MainController() {
        createAttributes();
        addListeners();
    }

    private void createAttributes() {
        model = new MainModel();
        login = new LoginView(model);
        connectionModel = new MainConnectionModel();
        connection = new MainConnection(connectionModel.getURL() + connectionModel.getDATABASE(), connectionModel.getUSERNAME(), connectionModel.getPASSWORD(), connectionModel.getDRIVER());
        orders = new ArrayList<>();
    }

    private void addListeners() {

    }
}
