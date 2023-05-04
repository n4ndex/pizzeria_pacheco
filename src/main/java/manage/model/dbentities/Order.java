package manage.model.dbentities;

import java.util.*;

public class Order {
    private int order_code;
    private String order_type;
    private Client client;
    private ArrayList<Pizza> pizzas;
    private boolean recieved;

    public Order(int order_code, String order_type, Client client, ArrayList<Pizza> pizzas) {

    }
}
