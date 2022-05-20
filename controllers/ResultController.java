package controllers;

import models.EstudianteModel;
import java.awt.event.ActionEvent;
import views.ResultUI;

public class ResultController extends ResultUI {
    int total;
    int actual = 1;
    EstudianteModel[] estudiantes;

    public ResultController(EstudianteModel[] estudiantes, int globalX, int globalY) {
        super(globalX, globalY);
        this.estudiantes = estudiantes;
        proccesFirstData();
        construct();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Action e:" + e.getActionCommand());

        if (e.getActionCommand() == "Siguiente")
            this.next();
        if (e.getActionCommand() == "Anterior")
            this.prev();
        if (e.getActionCommand() == "Guardar")
            this.save();
        if (e.getActionCommand() == "Imprimir")
            this.print();

    }

    public void next() {
        if (actual <= total) {
            actual++;
            setData();
            getContentPane().removeAll();
            construct();
            repaint();
        }
    }

    public void prev() {
        if (actual != 1) {
            actual--;
            setData();
            getContentPane().removeAll();
            construct();
            repaint();
        }
    }

    public void save() {
        if (actual != 1)
            actual--;
        setData();
    }

    public void print() {
        if (actual != 1)
            actual--;
        setData();
    }

    public void proccesFirstData() {
        this.total = estudiantes.length / 10;
        setData();
    }

    public void setData() {
        String[] columnNames = { "Id", "1 Nombre", "2 Nombre", "1 apellido", "2 Apellid",
                "Nota 1", "Nota 2", "Nota 3", "Nota final" };
        String[][] rowData = new String[estudiantes.length][9];
        rowData[0][0] = columnNames[0];
        rowData[0][1] = columnNames[1];
        rowData[0][2] = columnNames[2];
        rowData[0][3] = columnNames[3];
        rowData[0][4] = columnNames[4];
        rowData[0][5] = columnNames[5];
        rowData[0][6] = columnNames[6];
        rowData[0][7] = columnNames[7];
        rowData[0][8] = columnNames[8];
        int limit = (this.actual * 10) - 10;
        for (int i = 1; i <= 11; i++) {
            try {
                rowData[i][0] = this.estudiantes[(limit + i) - 1].getId() + "";
                rowData[i][1] = this.estudiantes[(limit + i) - 1].getPrimerNombre();
                rowData[i][2] = this.estudiantes[(limit + i) - 1].getSegundoNombre();
                rowData[i][3] = this.estudiantes[(limit + i) - 1].getPrimerApellido();
                rowData[i][4] = this.estudiantes[(limit + i) - 1].getSegundoApellido();
                rowData[i][5] = this.estudiantes[(limit + i) - 1].getNota1() + "";
                rowData[i][6] = this.estudiantes[(limit + i) - 1].getNota2() + "";
                rowData[i][7] = this.estudiantes[(limit + i) - 1].getNota3() + "";
                rowData[i][8] = this.estudiantes[(limit + i) - 1].getNotaFInal() + "";
            } catch (Exception e) {
                
            }
        }
        super.rowData = rowData;
        super.columnNames = columnNames;
        super.tabla = title.getTable(rowData, columnNames, 90, 10, 600, 400);
    }
}
