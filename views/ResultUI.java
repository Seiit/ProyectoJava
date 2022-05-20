package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import models.EstudianteModel;
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
        int alto = 600;

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
        JScrollPane tblCont = card.getCardScroll(0, 0, hX, hY);
        outputPanel = card.getCard(0, 0, hX, hY);

        tblCont.add(this.tabla);
        outputPanel.add(tblCont);

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