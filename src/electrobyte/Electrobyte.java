/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package electrobyte;
import view.*;
import controller.WelcomeController;

/**
 *
 * @author sahki
 */
public class Electrobyte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Welcome welcome  = new Welcome();
        WelcomeController controller = new WelcomeController(welcome);
        controller.OpenScreen();
    }
    
}
