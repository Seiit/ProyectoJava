import java.io.IOException;

import services.FileService;
import views.LoginUI;
import views.MainUI;

public class App{
    public static void main(String args[]) throws IOException{
        
        
        LoginUI login = new LoginUI();
        MainUI main = new MainUI();

        main.setVisible(true);
        

        FileService file = new FileService();

        file.readDb();
    }
}