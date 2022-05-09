package views;

import javax.swing.JFrame;

public class IndexUI extends JFrame{

    public IndexUI(){
        this.setTitle("App");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        startComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void startComponents(){
        LoginUI login = new LoginUI();
        this.getContentPane().add(login.getComponents());
    }


}
