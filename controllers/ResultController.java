package controllers;

import models.EstudianteModel;
import java.awt.event.ActionEvent;
import views.ResultUI;

public class ResultController extends ResultUI{
    int total;
    int actual=1;

    public ResultController(EstudianteModel [] estudiantes,int globalX, int globalY) {
        super(globalX, globalY);
        getData(estudiantes);
        construct();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Action e:"+e.getActionCommand());

       // if(e.getActionCommand() == "Calcular")this.calcular();
        
    }

    public void getData(EstudianteModel [] estudiantes){
        String[] columnNames = { "Id", "1 Nombre", "2 Nombre", "1 apellido", "2 Apellid",
                "Nota 1", "Nota 2", "Nota 3", "Nota final" };
        String[][] rowData = new String[estudiantes.length][9];
        this.total = estudiantes.length/10;

        rowData[0][0] = columnNames[0];
        rowData[0][1] = columnNames[1];
        rowData[0][2] = columnNames[2];
        rowData[0][3] = columnNames[3];
        rowData[0][4] = columnNames[4];
        rowData[0][5] = columnNames[5];
        rowData[0][6] = columnNames[6];
        rowData[0][7] = columnNames[7];
        rowData[0][8] = columnNames[8];

        for (int i = 1; i < 11+1; i++) {
            rowData[i][0] = estudiantes[i-1].getId() + "";
            rowData[i][1] = estudiantes[i-1].getPrimerNombre();
            rowData[i][2] = estudiantes[i-1].getSegundoNombre();
            rowData[i][3] = estudiantes[i-1].getPrimerApellido();
            rowData[i][4] = estudiantes[i-1].getSegundoApellido();
            rowData[i][5] = estudiantes[i-1].getNota1() + "";
            rowData[i][6] = estudiantes[i-1].getNota2() + "";
            rowData[i][7] = estudiantes[i-1].getNota3() + "";
            rowData[i][8] = estudiantes[i-1].getNotaFInal() + "";
        }

        super.rowData = rowData;
        super.columnNames = columnNames;
        super.tabla = title.getTable(rowData, columnNames, 0, 10, 800 - 15, 370);
    }
}
