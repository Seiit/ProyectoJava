package controllers;

import views.LoginUI;
import java.awt.event.ActionEvent;

public class LoginController extends LoginUI{

    public LoginController(int globalX, int globalY) {
        super(globalX, globalY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainController main = new MainController(700,650);
        main.setVisible(true);
        this.dispose();  
    }
    
}
