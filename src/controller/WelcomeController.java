/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Login;
import view.Welcome;

/**
 *
 * @author Hurri
 */
public class WelcomeController {
    private final Welcome welcome;
    public WelcomeController(Welcome welcome){
        this.welcome = welcome;
        welcome.GetStartedBtn().addActionListener(e -> GetStartedBtn());
    }
    
    public void OpenScreen(){
        welcome.setTitle("WelcomeScreen");
        welcome.setLocationRelativeTo(null);
        welcome.setResizable(false);
        welcome.setVisible(true);
    }
    
    public void CloseScreen(){
        welcome.dispose();
    }
    
    public void GetStartedBtn(){
        Login login = new Login();
        LoginController loginCtrl = new LoginController(login);
        loginCtrl.open();
        CloseScreen();
    }
}
