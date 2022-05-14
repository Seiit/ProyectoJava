package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import views.components.Title;
import views.components.VIewInterface;
import views.components.Card;
import views.components.Input;
import views.components.Submit;

public class LoginUI extends JFrame implements ActionListener , VIewInterface{

    public LoginUI() {

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(construct());

    }

    public JPanel construct() {
        int ancho = 400;
        int componentWidth = 300;
        int componentLeft = 50;

        Title title = new Title();
        Card card = new Card();
        Input input = new Input();
        Submit submit = new Submit();

        JPanel panel = card.getBackground();
        JPanel login = card.getCard(200, 75, ancho, 300);

        JLabel login_title = title.getH1("Inicio de Sesion", 0, 0, ancho, 50);

        JTextField username_input = input.getInput("Usuario", componentLeft, 70, componentWidth, 50);
        JTextField password_input = input.getPassInput("Contraseña", componentLeft, 130, componentWidth, 50);

        JButton loginBtn = submit.getActionButton("Iniciar", componentLeft, 200, componentWidth, 50);
        loginBtn.addActionListener(this);

        login.add(login_title);
        login.add(username_input);
        login.add(password_input);
        login.add(loginBtn);

        panel.add(login);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        MainUI main = new MainUI();
        main.setVisible(true);
        this.dispose();
        
    }
}
