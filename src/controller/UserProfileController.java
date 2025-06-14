package controller;

import dao.UserDao; // Make sure this import is present
import dao.UserProfileDao;
import model.UserProfile;
import view.Userprofile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileController {
    private final Userprofile view;
    private final int userId;
    private final UserProfileDao profileDao = new UserProfileDao();

    public UserProfileController(Userprofile view, int userId) {
        this.view = view;
        this.userId = userId;
        loadUserProfile();
        this.view.getSaveButton().addActionListener(new SaveListener());
    }

    private void loadUserProfile() {
        UserProfile profile = profileDao.getProfileByUserId(userId);
        if (profile != null) {
            view.getFullNameField().setText(profile.getFirstName());
            view.getLastNameField().setText(profile.getLastName());
            view.getAgeField().setText(String.valueOf(profile.getAge()));
            view.getGenderField().setText(profile.getGender());
            view.getCountryField().setText(profile.getCountry());
            view.getContactField().setText(profile.getContact());
            view.getAddressField().setText(profile.getAddress());
            view.getEmailField().setText(profile.getEmail());
        }
        // Set the username from users table
        UserDao userDao = new UserDao();
        String username = userDao.getUsernameById(userId);
        view.getUserNameLabel().setText(username);
    }

    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            UserProfile profile = new UserProfile();
            profile.setUserId(userId);
            profile.setFirstName(view.getFullNameField().getText());
            profile.setLastName(view.getLastNameField().getText());
            profile.setAge(Integer.parseInt(view.getAgeField().getText()));
            profile.setGender(view.getGenderField().getText());
            profile.setCountry(view.getCountryField().getText());
            profile.setContact(view.getContactField().getText());
            profile.setAddress(view.getAddressField().getText());
            profile.setEmail(view.getEmailField().getText());

            boolean success = profileDao.saveOrUpdateProfile(profile);
            if (success) {
                JOptionPane.showMessageDialog(view, "Profile updated successfully!");
                view.getUserNameLabel().setText(profile.getFirstName());
            } else {
                JOptionPane.showMessageDialog(view, "Failed to update profile.");
            }
        }
    }
}