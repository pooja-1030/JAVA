// program 9

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GucciStoreManagement extends JFrame {
    private JTextField productIdField, productNameField, productPriceField, productQuantityField;
    private JTextField customerNameField, customerContactField, customerEmailField;
    private JTable productTable, transactionTable;
    private DefaultTableModel productTableModel, transactionTableModel;

    public GucciStoreManagement() {
        setTitle("Gucci Store Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Product Panel
        JPanel productPanel = new JPanel(new GridLayout(5, 2));
        productPanel.setBorder(BorderFactory.createTitledBorder("Product Management"));

        productIdField = new JTextField();
        productNameField = new JTextField();
        productPriceField = new JTextField();
        productQuantityField = new JTextField();

        productPanel.add(new JLabel("Product ID:"));
        productPanel.add(productIdField);
        productPanel.add(new JLabel("Product Name:"));
        productPanel.add(productNameField);
        productPanel.add(new JLabel("Price:"));
        productPanel.add(productPriceField);
        productPanel.add(new JLabel("Quantity:"));
        productPanel.add(productQuantityField);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.addActionListener(new AddProductActionListener());
        productPanel.add(addProductButton);

        productTableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Price", "Quantity"}, 0);
        productTable = new JTable(productTableModel);
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        // Customer Panel
        JPanel customerPanel = new JPanel(new GridLayout(4, 2));
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Management"));

        customerNameField = new JTextField();
        customerContactField = new JTextField();
        customerEmailField = new JTextField();

        customerPanel.add(new JLabel("Name:"));
        customerPanel.add(customerNameField);
        customerPanel.add(new JLabel("Contact:"));
        customerPanel.add(customerContactField);
        customerPanel.add(new JLabel("Email:"));
        customerPanel.add(customerEmailField);

        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.addActionListener(new AddCustomerActionListener());
        customerPanel.add(addCustomerButton);

        // Transaction Panel
        JPanel transactionPanel = new JPanel();
        transactionPanel.setBorder(BorderFactory.createTitledBorder("Transaction"));

        transactionTableModel = new DefaultTableModel(new Object[]{"Product ID", "Product Name", "Quantity", "Total Price"}, 0);
        transactionTable = new JTable(transactionTableModel);
        transactionPanel.add(new JScrollPane(transactionTable));

        // Add panels to the main frame
        add(productPanel, BorderLayout.WEST);
        add(customerPanel, BorderLayout.EAST);
        add(transactionPanel, BorderLayout.SOUTH);
    }

    // Action Listeners for buttons (inner classes)
    private class AddProductActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = productIdField.getText();
            String name = productNameField.getText();
            String priceText = productPriceField.getText();
            String quantityText = productQuantityField.getText();

            // Validate and add product details to the table
            if (!id.isEmpty() && !name.isEmpty() && isNumeric(priceText) && isNumeric(quantityText)) {
                double price = Double.parseDouble(priceText);
                int quantity = Integer.parseInt(quantityText);
                productTableModel.addRow(new Object[]{id, name, price, quantity});
                clearProductFields();
            } else {
                JOptionPane.showMessageDialog(GucciStoreManagement.this, "Please enter valid product details.");
            }
        }

        private void clearProductFields() {
            productIdField.setText("");
            productNameField.setText("");
            productPriceField.setText("");
            productQuantityField.setText("");
        }
    }

    private class AddCustomerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = customerNameField.getText();
            String contact = customerContactField.getText();
            String email = customerEmailField.getText();

            // Validate and add customer details
            if (!name.isEmpty() && contact.matches("\\d{10}") && email.contains("@")) {
                // Logic to save customer details
                clearCustomerFields();
            } else {
                JOptionPane.showMessageDialog(GucciStoreManagement.this, "Please enter valid customer details.");
            }
        }

        private void clearCustomerFields() {
            customerNameField.setText("");
            customerContactField.setText("");
            customerEmailField.setText("");
        }
    }

    // Utility to check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GucciStoreManagement().setVisible(true));
    }
}
