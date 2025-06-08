package dao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTableDaoTest {

    @Test
    public void testGetAllUsers() {
        UserTableDao dao = new UserTableDao();
        List result = dao.getAllUsers();
        assertNotNull("getAllUsers should not return null", result);
        assertFalse("User list should not be empty", result.isEmpty());
    }
}