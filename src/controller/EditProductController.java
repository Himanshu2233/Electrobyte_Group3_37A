package controller;

import dao.ProductDao;
import model.Product;
import view.EditProduct;

import javax.swing.*;

public class EditProductController {
    private final EditProduct view;
    private final ProductDao dao = new ProductDao();

    public EditProductController(EditProduct view) {
        this.view = view;
        this.view.addEditProductListener(e -> updateProduct());
    }

    private void updateProduct() {
        try {
            String name = view.getProductName();
            String desc = view.getDescription();
            double price = Double.parseDouble(view.getPrice());
            String category = view.getCategory();
            String imageUrl = view.getImageUrl();
            int stock = view.getStock();
            int productId = view.getProductId();

            if (name.isEmpty() || category.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Name and Category are required.");
                return;
            }

            Product updatedProduct = new Product(productId, name, desc, price, category, imageUrl, stock);
            boolean success = dao.updateProduct(updatedProduct);

            if (success) {
                JOptionPane.showMessageDialog(view, "Product updated successfully!");
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Failed to update product.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Invalid price or stock value.");
        }
    }
}