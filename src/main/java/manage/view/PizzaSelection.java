package manage.view;

import lombok.Getter;
import lombok.Setter;
import manage.model.MainModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Getter
@Setter
public class PizzaSelection extends JFrame {
    private JTable pizzasTable;
    private DefaultTableModel defaultTableModel;
    private JButton finishButton;

    public PizzaSelection(MainModel model, ResultSet defaultPizzas) {
        createAddAttributes(model, defaultPizzas);
        setAttributes(model.getControlTexts().get(0));
    }

    private void createAddAttributes(MainModel model, ResultSet defaultPizzas) {
        pizzasTable = new JTable();
        JPanel panel = new JPanel(new FlowLayout());
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSetMetaData pizzasMetadata = defaultPizzas.getMetaData();
            int columnTotal = pizzasMetadata.getColumnCount();
            for (int i = 1; i <= columnTotal; i++) {
                defaultTableModel.addColumn(pizzasMetadata.getColumnName(i));
            }
            Object[] fieldLabel = new Object[columnTotal];
            for (int i = 1; i <= columnTotal; i++){
            fieldLabel[i - 1] = pizzasMetadata.getColumnLabel(i);
            }
            defaultTableModel.addRow(fieldLabel);

            while (defaultPizzas.next()) {
                Object[] rows = new Object[columnTotal];
                for (int i = 1; i <= columnTotal; i++) {
                    rows[i - 1] = defaultPizzas.getObject(i);
                }
                defaultTableModel.addRow(rows);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pizzasTable.setModel(defaultTableModel);
        panel.add(pizzasTable);

        finishButton = new JButton(model.getControlTexts().get(1));
        panel.add(finishButton);

        add(panel);
    }

    private void setAttributes(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        pack();
        setVisible(false);
        setLocationRelativeTo(null);
    }
}
