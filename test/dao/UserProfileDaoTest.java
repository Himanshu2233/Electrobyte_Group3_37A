package dao;

import model.UserProfile;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserProfileDaoTest {

    @Test
    public void testSaveOrUpdateProfile() {
        UserProfileDao dao = new UserProfileDao();
        UserProfile profile = new UserProfile();
        profile.setUserId(1);
        profile.setFirstName("Test");
        profile.setLastName("User");
        profile.setAge(25);
        profile.setGender("Male");
        profile.setCountry("Country");
        profile.setContact("1234567890");
        profile.setAddress("Address");
        profile.setEmail("testuser1@gmail.com");
        boolean result = dao.saveOrUpdateProfile(profile);
        assertTrue("Profile should be saved or updated", result);
    }
}