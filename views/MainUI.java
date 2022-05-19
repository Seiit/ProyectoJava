package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.EstudianteModel;
import views.components.VIewInterface;
import views.components.Card;
import views.components.Input;
import views.components.Submit;
import views.components.Title;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener, VIewInterface {

    JTextField nota1;
    JTextField nota2;
    JTextField nota3;

    JLabel idTxt;
    JLabel primerNombreTxt;
    JLabel segundoNombreTxt;
    JLabel primerApellidoTxt;
    JLabel segundoApellidoTxt;
    JLabel nota1Txt;
    JLabel nota2Txt;
    JLabel nota3Txt;
    JLabel notaFinal;

    public MainUI() {

        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.construct();
        this.getContentPane().add(construct());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Calcular") {

            double n1 = (this.nota1.getText().length() == 0)?0:Double.parseDouble(this.nota1.getText());
            double n2 = (this.nota2.getText().length() == 0)?0:Double.parseDouble(this.nota2.getText());
            double n3 = (this.nota3.getText().length() == 0)?0:Double.parseDouble(this.nota3.getText());

            this.printData(new EstudianteModel(
                    0,
                    "",
                    "",
                    "",
                    "",
                    n1,
                    n2,
                    n3
                )
            );
        }
    }

    public void printData(EstudianteModel estudiante){
        this.idTxt.setText(estudiante.getId()+"");
        this.primerNombreTxt.setText(estudiante.getPrimerNombre());
        this.segundoNombreTxt.setText(estudiante.getSegundoNombre());
        this.primerApellidoTxt.setText(estudiante.getPrimerApellido());
        this.segundoApellidoTxt.setText(estudiante.getSegundoApellido());
        this.nota1Txt.setText(""+estudiante.getNota1());
        this.nota2Txt.setText(""+estudiante.getNota2());
        this.nota3Txt.setText(""+estudiante.getNota3());
        this.notaFinal.setText(""+estudiante.getNotaFInal());
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
        JPanel mainContent = card.getCard(40, 25, ancho, 600);

        JLabel main_title = title.getH1("Gestor de notas", 0, 0, ancho, 50);
        JLabel main_title2 = title.getH1("Calculo unitario", 0, 0, 350, 50);
        JLabel main_title3 = title.getH1("Resultado", 0, 0, 350, 50);

        this.nota1 = input.getNumberInput("Nota1", componentLeft, 70, componentWidth, 50);
        this.nota2 = input.getNumberInput("Nota2", componentLeft, 120, componentWidth, 50);
        this.nota3 = input.getNumberInput("Nota3", componentLeft, 170, componentWidth, 50);
        JButton unicoBtn = submit.getActionButton("Calcular", componentLeft, 230, componentWidth, 50);
        unicoBtn.addActionListener(this);

        this.idTxt = title.getTH2("Id", 25, 70, componentWidth, 50);
        this.primerNombreTxt = title.getTH2("Primer Nombre", 25, 120, componentWidth, 50);
        this.segundoNombreTxt = title.getTH2("Segundo Nombre", 25, 170, componentWidth, 50);
        this.primerApellidoTxt = title.getTH2("Primer Apellido", 25, 220, componentWidth, 50);
        this.segundoApellidoTxt = title.getTH2("Segundo Apellido", 25, 270, componentWidth, 50);
        this.nota1Txt = title.getTH2("Nota1", 25, 320, componentWidth, 50);
        this.nota2Txt = title.getTH2("Nota2", 25, 370, componentWidth, 50);
        this.nota3Txt = title.getTH2("Nota3", 25, 420, componentWidth, 50);
        this.notaFinal = title.getTH2("Nota FInal", 25, 470, componentWidth, 50);

        JPanel content = card.getCard(0, 50, ancho, 600);
        JPanel inputPanel = card.getCard(0, 0, 350, 600);
        JPanel outputPanel = card.getCard(350, 0, 350, 600);

        mainContent.add(main_title);

        // Construimos el primer cuadro
        inputPanel.add(main_title2);
        inputPanel.add(nota1);
        inputPanel.add(nota2);
        inputPanel.add(nota3);
        inputPanel.add(unicoBtn);
        content.add(inputPanel);// Panel Izquierda

        // COnstruimos el segundo cuadro
        outputPanel.add(main_title3);
        outputPanel.add(idTxt);
        outputPanel.add(primerNombreTxt);
        outputPanel.add(segundoNombreTxt);
        outputPanel.add(primerApellidoTxt);
        outputPanel.add(segundoApellidoTxt);
        outputPanel.add(nota1Txt);
        outputPanel.add(nota2Txt);
        outputPanel.add(nota3Txt);
        outputPanel.add(notaFinal); 

        content.add(outputPanel);// Panel derecha

        mainContent.add(content);
        panel.add(mainContent);

        return panel;
    }

}
