package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import views.components.VIewInterface;
import views.components.Card;
import views.components.Input;
import views.components.Submit;
import views.components.Title;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener , VIewInterface{

    public MainUI() {

        this.setSize(800, 650);
        this.setLocationRelativeTo(null);
        this.construct();
        this.getContentPane().add(construct());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public JPanel construct() {
        int ancho = 700;
        int componentWidth = 300;
        int componentLeft = 40;
        
        Title title = new Title();
        Card card = new Card();
        Input input = new Input();
        Submit submit = new Submit();

        JPanel panel = card.getBackground();
        JPanel mainContent = card.getCard(40, 25, ancho, 550);

        JLabel main_title = title.getH1("Gestor de notas", 0, 0, ancho, 50);
        JLabel main_title2 = title.getH1("Calculo unitario", 0, 0, 350, 50);
        JLabel main_title3 = title.getH1("Resultado", 0, 0, 350, 50);

        JTextField primerNombre = input.getInput("Primer Nombre", componentLeft, 70, componentWidth, 50);
        JTextField segundoNombre = input.getInput("Segundo Nombre", componentLeft, 120, componentWidth, 50);
        JTextField primerApellido = input.getInput("Primer Apellido", componentLeft, 170, componentWidth, 50);
        JTextField segundoApellido = input.getInput("Segundo Apellido", componentLeft, 220, componentWidth, 50);
        JTextField nota1 = input.getNumberInput("Nota1", componentLeft, 270, componentWidth, 50);
        JTextField nota2 = input.getNumberInput("Nota2", componentLeft, 320, componentWidth, 50);
        JTextField nota3 = input.getNumberInput("Nota3", componentLeft, 370, componentWidth, 50);
        JButton unicoBtn = submit.getActionButton("Calcular", componentLeft, 430, componentWidth, 50);
        unicoBtn.addActionListener(this);
        
        JLabel nombre_txt = title.getTH2("Main3", 0, 50, 350, 50);
        JLabel primerNombreTxt = title.getTH2("Primer Nombre", 25, 70, componentWidth, 50);
        JLabel segundoNombreTxt = title.getTH2("Segundo Nombre", 25, 120, componentWidth, 50);
        JLabel primerApellidoTxt = title.getTH2("Primer Apellido", 25, 170, componentWidth, 50);
        JLabel segundoApellidoTxt = title.getTH2("Segundo Apellido", 25, 220, componentWidth, 50);
        JLabel nota1Txt = title.getTH2("Nota1", 25, 270, componentWidth, 50);
        JLabel nota2Txt = title.getTH2("Nota2", 25, 320, componentWidth, 50);
        JLabel nota3Txt = title.getTH2("Nota3", 25, 370, componentWidth, 50);

        JPanel content = card.getCard(0, 50, ancho, 500);
        JPanel inputPanel = card.getCard(0, 0, 350, 500);
        JPanel outputPanel = card.getCard(350, 0, 350, 500);

        mainContent.add(main_title);

        //Construimos el primer cuadro
        inputPanel.add(main_title2);
        inputPanel.add(primerNombre);
        inputPanel.add(segundoNombre);
        inputPanel.add(primerApellido);
        inputPanel.add(segundoApellido);
        inputPanel.add(nota1);
        inputPanel.add(nota2);
        inputPanel.add(nota3);
        inputPanel.add(unicoBtn);
        content.add(inputPanel);//Panel Izquierda

        //COnstruimos el segundo cuadro
        outputPanel.add(main_title3);
        outputPanel.add(primerNombreTxt);
        outputPanel.add(segundoNombreTxt);
        outputPanel.add(primerApellidoTxt);
        outputPanel.add(segundoApellidoTxt);
        outputPanel.add(nota1Txt);
        outputPanel.add(nota2Txt);
        outputPanel.add(nota3Txt);
        
        content.add(outputPanel);//Panel derecha
        
        mainContent.add(content);
        panel.add(mainContent);
        
        return panel;
    }

}
