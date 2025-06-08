package dao;

import org.junit.Test;
import static org.junit.Assert.*;

public class ForgotTest {

    @Test
    public void testValidateSecurityAnswer() {
        Forgot dao = new Forgot();
        boolean result = dao.validateSecurityAnswer("testuser1", "testuser1@gmail.com", "dog");
        assertTrue("Security answer should be valid", result);
    }
}