package dao;

import model.Product;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class CartDaoTest {

    private final CartDao cartDao = new CartDao();
    private final int testUserId = 9; // Use the user_id from signup
    private final int testProductId = 21; // Use the product id from add product

    @Test
    public void testAddToCart() {
        cartDao.clearCart(testUserId);
        boolean result = cartDao.addToCart(testUserId, testProductId, 2);
        assertTrue("Product should be added to cart", result);

        List<Product> cartItems = cartDao.getCartItems(testUserId);
        boolean found = cartItems.stream().anyMatch(p -> p.getProductId() == testProductId);
        assertTrue("Product should be in cart after adding", found);
    }

    @Test
    public void testGetCartItems() {
        CartDao dao = new CartDao();
        cartDao.clearCart(testUserId);
        cartDao.addToCart(testUserId, testProductId, 1);
        List<Product> cartItems = cartDao.getCartItems(testUserId);
        assertNotNull("Cart items should not be null", cartItems);
        assertFalse("Cart should not be empty after adding", cartItems.isEmpty());
    }

    @Test
    public void testRemoveFromCart() {
        CartDao dao = new CartDao();
        cartDao.clearCart(testUserId);
        cartDao.addToCart(testUserId, testProductId, 1);
        cartDao.removeFromCart(testUserId, testProductId);

        List<Product> cartItems = cartDao.getCartItems(testUserId);
        boolean found = cartItems.stream().anyMatch(p -> p.getProductId() == testProductId);
        assertFalse("Product should not be in cart after removal", found);
    }

    @Test
    public void testClearCart() {
        CartDao dao = new CartDao();
        cartDao.addToCart(testUserId, testProductId, 1);
        cartDao.clearCart(testUserId);

        List<Product> cartItems = cartDao.getCartItems(testUserId);
        assertTrue("Cart should be empty after clearing", cartItems.isEmpty());
    }

    @Test
    public void testUpdateQuantity() {
        CartDao dao = new CartDao();
        cartDao.clearCart(testUserId);
        cartDao.addToCart(testUserId, testProductId, 1);
        cartDao.updateQuantity(testUserId, testProductId, 5);

        List<Product> cartItems = cartDao.getCartItems(testUserId);
        Product product = cartItems.stream()
            .filter(p -> p.getProductId() == testProductId)
            .findFirst().orElse(null);

        assertNotNull("Product should be in cart after update", product);
        assertEquals("Quantity should be updated", 5, product.getQuantity());
    }
}
