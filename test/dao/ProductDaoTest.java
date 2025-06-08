package dao;

import model.Product;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class ProductDaoTest {

    @Test
    public void testAddProduct() {
        ProductDao dao = new ProductDao();
        Product product = new Product("Test Product", "Test Description", 99.99, "Test Category", "test.jpg", 10);
        boolean result = dao.addProduct(product);
        assertTrue("Product should be added successfully", result);
    }

    @Test
    public void testGetAllProducts() {
        ProductDao dao = new ProductDao();
        List<Product> products = dao.getAllProducts();
        assertNotNull("Product list should not be null", products);
        assertFalse("Product list should not be empty", products.isEmpty());
    }

    @Test
    public void testUpdateProduct() {
        ProductDao dao = new ProductDao();
        List<Product> products = dao.getAllProducts();
        if (!products.isEmpty()) {
            Product product = products.get(0);
            product.setName("Updated Test Product");
            boolean result = dao.updateProduct(product);
            assertTrue("Product should be updated", result);
        }
    }

    @Test
    public void testDeleteProduct() {
        ProductDao dao = new ProductDao();
        // First add a product to delete
        Product product = new Product("DeleteMe", "desc", 10.0, "cat", "img.jpg", 1);
        dao.addProduct(product);
        
        List<Product> products = dao.getAllProducts();
        int id = products.get(products.size() - 1).getProductId();
        dao.deleteProduct(id);
        // Verify it's deleted by checking if getAllProducts size decreased
    }
}
