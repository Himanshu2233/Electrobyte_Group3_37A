/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDao;
import view.Signup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.User;

/**s
 *
 * @author sahki
 */
public class SignupController {
    private final UserDao userDao = new UserDao();
    private final Signup userView;

    public SignupController(Signup userView) {
        this.userView = userView;
        userView.addAddUserListener(new AddUserListener());
    }
    public void open() {
        userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = userView.getUsernameField().getText();
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordField().getText();
                User user = new User(name, email, password);
                boolean check = userDao.checkUser(user);
                if (check) {
                    JOptionPane.showMessageDialog(userView, "User already exists");

                }else {
                    userDao.signUp(user);
                }
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(userView, "Error: " + ex.getMessage());
            }
        } 
    }
}
