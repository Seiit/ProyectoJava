import views.LoginUI;
import views.MainUI;

public class App{
    public static void main(String args[]){
        
        LoginUI login = new LoginUI();
        MainUI main = new MainUI();

        main.setVisible(true);
    }
}