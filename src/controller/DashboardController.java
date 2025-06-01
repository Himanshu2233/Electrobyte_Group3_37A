// controller/DashboardController.java
package controller;

import model.Product;
import view.Dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardController {
    private Dashboard dashboard;

    public DashboardController(Dashboard dashboard) {
        this.dashboard = dashboard;

        // Attach listener to the Add button
        dashboard.addProductListener(new AddProductListener());
    }

    // Inner class to handle Add button clicks
    class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = dashboard.getProductName().getText();
                double price = Double.parseDouble(dashboard.getProductPrice().getText());
                String image = dashboard.getProductImage().getText();

                Product product = new Product(name, price, image);
                
                // Simulate saving the product
                System.out.println("Product added: " + product);

                // Show confirmation
                JOptionPane.showMessageDialog(dashboard, "Product added successfully!");
 
               // Clear fields
                dashboard.getProductName().setText("");
                dashboard.getProductPrice().setText("");
                dashboard.getProductImage().setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dashboard, "Invalid price. Please enter a number.");
            }
        }
    }
}
