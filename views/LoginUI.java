package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import views.components.ViewInterface;
import views.components.ViewModel;
import views.components.Card;
import views.components.Input;
import views.components.Submit;
import views.components.Title;

public class LoginUI extends ViewModel implements ActionListener , ViewInterface {
    
    public LoginUI(int globalX, int globalY) {
        super(globalX, globalY);
        this.construct();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void construct() {
        int ancho = 400;
        int componentWidth = 300;
        int componentLeft = 50;

        Title title = new Title();
        Card card = new Card();
        Input input = new Input();
        Submit submit = new Submit();

        JPanel panel = card.getBackground();
        JPanel login = card.getCard(20, 20, ancho, 300);

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

        this.getContentPane().add(panel);
    }

    @Override
    public void leftCont(int hX,int hY,int lMargin,int width) {
        
    }

    @Override
    public void rightCont(int hX,int hY,int lMargin,int width) {
        
    }

    @Override
    public void cont(int hX,int hY) {
        // TODO Auto-generated method stub
        
    }

}
