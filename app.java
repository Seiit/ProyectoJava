import java.io.IOException;

import controllers.LoginController;

public class App{
    public static void main(String args[]) throws IOException{
        
        LoginController login = new LoginController(450,380);

        login.setVisible(true);
        
    }
}
