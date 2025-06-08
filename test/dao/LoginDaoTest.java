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
public class LoginDaoTest {
    
    public LoginDaoTest() {
    }
    

    /**
     * Test of userlogin method, of class LoginDao.
     */
    @Test
    public void testUserlogin() {
        System.out.println("userlogin");
        User user = null;
        LoginDao instance = new LoginDao();
        boolean expResult = false;
        boolean result = instance.userlogin(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByUsername method, of class LoginDao.
     */
    @Test
    public void testGetUserByUsername() {
        System.out.println("getUserByUsername");
        String username = "";
        LoginDao instance = new LoginDao();
        User expResult = null;
        User result = instance.getUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testUserloginWithValidCredentials() {
        LoginDao dao = new LoginDao();
        // Use the same credentials as in signup
        User user = new User("testuser1", "password123");
        boolean result = dao.userlogin(user);
        assertTrue("Login should succeed for correct credentials", result);
    }
}
