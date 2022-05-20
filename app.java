import java.io.IOException;

import controllers.LoginController;
import controllers.ResultController;
import models.EstudianteModel;
import services.FileService;

public class App{
    public static void main(String args[]) throws IOException{
        
        LoginController login = new LoginController(450,380);

        //login.setVisible(true);
        


        FileService file = new FileService();
        EstudianteModel estudiantes[] = file.readDb();

        ResultController resultController = new ResultController(estudiantes, 800, 650);
        resultController.setVisible(true);
    }
}
