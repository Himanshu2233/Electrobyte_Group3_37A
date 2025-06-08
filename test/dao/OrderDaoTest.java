package dao;

import model.Order;
import model.OrderItem;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class OrderDaoTest {

    @Test
    public void testPlaceOrder() {
        OrderDao dao = new OrderDao();
        Order order = new Order();
        order.setUserId(9);
        order.setFirstName("Test");
        order.setLastName("User");
        order.setPhone("1234567890");
        order.setEmail("testuser1@gmail.com");
        order.setProvince("Province");
        order.setCity("City");
        order.setPostalCode("12345");
        order.setStreetAddress("Street 1");
        order.setTole("Tole");
        OrderItem item = new OrderItem();
        item.setProductId(21);
        item.setQuantity(2);
        item.setPrice(99.99);
        order.setItems(Arrays.asList(item));
        boolean result = dao.placeOrder(order);
        assertTrue("Order should be placed successfully", result);
    }
}