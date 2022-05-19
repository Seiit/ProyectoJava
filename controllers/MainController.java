package controllers;

import views.MainUI;
import java.awt.event.ActionEvent;
import java.io.IOException;

import models.EstudianteModel;
import services.FileService;

public class MainController extends MainUI{

    public MainController(int globalX, int globalY) {
        super(globalX, globalY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Action e:"+e.getActionCommand());

        if(e.getActionCommand() == "Calcular")this.calcular();
        if(e.getActionCommand() == "Buscar")
            try {
                this.Buscar();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        
        
    }

    public void calcular(){
        double n1 = (this.nota1.getText().length() == 0)?0:Double.parseDouble(this.nota1.getText());
        double n2 = (this.nota2.getText().length() == 0)?0:Double.parseDouble(this.nota2.getText());
        double n3 = (this.nota3.getText().length() == 0)?0:Double.parseDouble(this.nota3.getText());

        printData(new EstudianteModel(
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

    public void Buscar() throws IOException{
        FileService file = new FileService();
        EstudianteModel estudiantes[] = file.readDb();

        int id = Integer.parseInt(super.id.getText());

        for(int i=0 ; i < estudiantes.length ;i++){
            if(estudiantes[i].getId() == id){
                printData(estudiantes[i]);
            }
        }
    }

}
