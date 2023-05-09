package manage.controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PizzaSelectionListener implements ListSelectionListener {
    MainController controller;

    public PizzaSelectionListener(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JTable pizzasTable = controller.getPizzaSelection().getPizzasTable();
        int row = pizzasTable.getSelectedRow();
        /*int column = pizzasTable.getSelectedColumn();
        if (row >= 0 && column >= 0) {
            Object valor = pizzasTable.getValueAt(row, column);
            System.out.println("Fila: " + row + ", Columna: " + column + ", Valor: " + valor.toString());
        }*/
        int pizza_code = (int) pizzasTable.getValueAt(row, 0);
        String pizza_name = (String) pizzasTable.getValueAt(row, 1);
        double prize = (double) pizzasTable.getValueAt(row, 2);
        String pizza_size = (String) pizzasTable.getValueAt(row, 3);
        controller.getConnection().addNewPizzaToOrder(pizza_code, pizza_name, prize, pizza_size, controller.getCurrentOrderIndex());
    }
}
