package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.EstudianteModel;
import views.components.Card;
import views.components.Input;
import views.components.Submit;
import views.components.Title;
import views.components.ViewInterface;
import views.components.ViewModel;

public class MainUI extends ViewModel implements ActionListener, ViewInterface{
    Title title = new Title();
    Card card = new Card();
    Input input = new Input();
    Submit submit = new Submit();

    protected JTextField id;
    protected JTextField nota1;
    protected JTextField nota2;
    protected JTextField nota3;

    JLabel idTxt;
    JLabel primerNombreTxt;
    JLabel segundoNombreTxt;
    JLabel primerApellidoTxt;
    JLabel segundoApellidoTxt;
    JLabel nota1Txt;
    JLabel nota2Txt;
    JLabel nota3Txt;
    JLabel notaFinal;

    public MainUI(int globalX, int globalY) {
        super(globalX, globalY);
        construct();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void construct() {
        int ancho = 700;
        int alto = 600;

        JPanel mainContent = card.getCard(0, 0, ancho, alto);
        JLabel main_title = title.getH1("Gestor de notas", 0, 0, ancho, 50);


        leftCont(ancho/2,alto,40,300);
        rightCont(ancho/2,alto,25,280);
        cont(ancho,alto);
        mainContent.add(main_title);

        mainContent.add(getCont());

        this.getContentPane().add(mainContent);
    }

    @Override
    public void leftCont(int hX,int hY,int lMargin,int width) {
        JPanel inputPanel = getLeftContent();
        inputPanel = card.getCard(0, 0, hX, hY);

        JLabel main_title2 = title.getH1("Calculo unitario", 0, 0, 350, 50);

        this.nota1 = input.getNumberInput("Nota1", lMargin, 70, width, 50);
        this.nota2 = input.getNumberInput("Nota2", lMargin, 120, width, 50);
        this.nota3 = input.getNumberInput("Nota3", lMargin, 170, width, 50);

        JButton unicoBtn = submit.getActionButton("Calcular", lMargin, 230, width, 50);
        unicoBtn.addActionListener(this);

        this.id = input.getNumberInput("Id", lMargin, 290, width, 50);
        
        JButton findBtn = submit.getActionButton("Buscar", lMargin, 350, width, 50);
        findBtn.addActionListener(this);

        inputPanel.add(main_title2);
        inputPanel.add(nota1);
        inputPanel.add(nota2);
        inputPanel.add(nota3);
        inputPanel.add(unicoBtn);
        inputPanel.add(id);
        inputPanel.add(findBtn);

        setLeftContent(inputPanel);
    }

    @Override
    public void rightCont(int hX,int hY,int lMargin,int width) {
        JPanel outputPanel = getRightContent();
        outputPanel = card.getCard(350, 0, hX, hY);

        JLabel main_title3 = title.getH1("Resultado", 0, 0, 350, 50);
        
        this.idTxt = title.getTH2("Id", lMargin, 70, width, 50);
        this.primerNombreTxt = title.getTH2("Primer Nombre", lMargin, 120, width, 50);
        this.segundoNombreTxt = title.getTH2("Segundo Nombre", lMargin, 170, width, 50);
        this.primerApellidoTxt = title.getTH2("Primer Apellido", lMargin, 220, width, 50);
        this.segundoApellidoTxt = title.getTH2("Segundo Apellido", lMargin, 270, width, 50);
        this.nota1Txt = title.getTH2("Nota1", lMargin, 320, width, 50);
        this.nota2Txt = title.getTH2("Nota2", lMargin, 370, width, 50);
        this.nota3Txt = title.getTH2("Nota3", lMargin, 420, width, 50);
        this.notaFinal = title.getTH2("Nota FInal", lMargin, 470, width, 50);

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

        setRightContent(outputPanel);
    }

    @Override
    public void cont(int hX,int hY) {
        JPanel cont = getCont();
        cont = card.getCard(0, 50, hX, hY);

        cont.add(getLeftContent());
        cont.add(getRightContent());
        
        setCont(cont);
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

}
