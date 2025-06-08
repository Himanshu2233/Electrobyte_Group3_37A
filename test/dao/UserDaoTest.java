/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Himu
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    

    /**
     * Test of signUp method, of class UserDao.
     */
    @Test
    public void testSignUp() {
        UserDao dao = new UserDao();
        // Use a unique username/email for each test run to avoid conflicts
        User user = new User("testuser1", "testuser1@gmail.com", "password123", "What is your pet's name?", "dog");
        dao.signUp(user);
        // Now check if the user exists
        boolean exists = dao.checkUser(user);
        assertTrue("User should exist after signup", exists);
    }

    /**
     * Test of checkUser method, of class UserDao.
     */
    @Test
    public void testCheckUser() {
        System.out.println("checkUser");
        User user = null;
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.checkUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsernameById method, of class UserDao.
     */
    @Test
    public void testGetUsernameById() {
        System.out.println("getUsernameById");
        int userId = 0;
        UserDao instance = new UserDao();
        String expResult = "";
        String result = instance.getUsernameById(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalActiveUsers method, of class UserDao.
     */
    @Test
    public void testGetTotalActiveUsers() {
        System.out.println("getTotalActiveUsers");
        UserDao instance = new UserDao();
        int expResult = 0;
        int result = instance.getTotalActiveUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
