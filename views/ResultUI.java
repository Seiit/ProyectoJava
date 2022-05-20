package views;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import views.components.Card;
import views.components.Input;
import views.components.Submit;
import views.components.Title;
import views.components.ViewInterface;
import views.components.ViewModel;

public class ResultUI extends ViewModel implements ActionListener, ViewInterface {
    protected Title title = new Title();
    Card card = new Card();
    Input input = new Input();
    Submit submit = new Submit();

    protected String[] columnNames;
    protected String [][] rowData;
    protected JTable tabla;

    public ResultUI(int globalX, int globalY) {
        super(globalX, globalY);
        //construct();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void construct() {
        int ancho = 800;
        int alto = 750;

        JPanel mainContent = card.getCard(0, 0, ancho, alto);
        JLabel main_title = title.getH1("Gestor de notas", 0, 0, ancho, 50);

        rightCont(ancho, alto, 40, 300);
        cont(ancho, alto);
        mainContent.add(main_title);

        mainContent.add(getCont());
        this.getContentPane().add(mainContent);
    }

    @Override
    public void leftCont(int hX, int hY, int lMargin, int width) {

    }

    @Override
    public void rightCont(int hX, int hY, int lMargin, int width) {
        JPanel outputPanel = getLeftContent();
        outputPanel = card.getCard(0, 0, hX, hY);
        
        JButton nextBtn = submit.getActionButton("Siguiente", 425, 420, width, 50);
        nextBtn.addActionListener(this);

        JButton prevBtn = submit.getActionButton("Anterior", 60, 420, width, 50);
        prevBtn.addActionListener(this);

        JButton saveBtn = submit.getActionButton("Guardar", 425, 490, width, 50);
        saveBtn.addActionListener(this);

        JButton printBtn = submit.getActionButton("Imprimir", 60, 490, width, 50);
        printBtn.addActionListener(this);
        
        outputPanel.add(this.tabla);
        outputPanel.add(prevBtn);
        outputPanel.add(nextBtn);
        outputPanel.add(printBtn);
        outputPanel.add(saveBtn);
        setRightContent(outputPanel);
    }

    @Override
    public void cont(int hX, int hY) {
        JPanel cont = getCont();
        cont = card.getCard(0, 50, hX, hY);

        cont.add(getRightContent());

        setCont(cont);
    }

}