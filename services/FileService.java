package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.EstudianteModel;

public class FileService {
    String urlFile = "C:/app/data.csv";
    File fileObj;

    public FileService(String url) throws IOException {
        this.urlFile = url;
        this.init();
    }

    public FileService() throws IOException {
        this.init();
    }

    public void addData(EstudianteModel[] estudianteModel) throws IOException {
        int total = 0;
        EstudianteModel[] db = readDb();
        total = db.length + estudianteModel.length;
        EstudianteModel[] consolidado = new EstudianteModel[total];

        for (int i = 0; i < db.length; i++) {
            consolidado[i] = db[i];
        }

        for (int i = 0; i < estudianteModel.length; i++) {
            try {
                consolidado[db.length + i] = estudianteModel[i];
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        this.write(consolidado);
    }

    public void write(EstudianteModel[] estudianteModel) throws IOException {
        FileWriter fw = new FileWriter(fileObj);
        BufferedWriter bw = new BufferedWriter(fw);

        String res = "";

        for (int i = 0; i < estudianteModel.length; i++) {
            res += estudianteModel[i].getId() + "," +
                    estudianteModel[i].getPrimerNombre() + "," +
                    estudianteModel[i].getSegundoNombre() + "," +
                    estudianteModel[i].getPrimerApellido() + "," +
                    estudianteModel[i].getSegundoApellido() + "," +
                    estudianteModel[i].getNota1() + "," +
                    estudianteModel[i].getNota2() + "," +
                    estudianteModel[i].getNota3() + "\n";
        }
        bw.write(res);
        bw.flush();
        bw.close();

    }

    public void init() throws IOException {
        System.out.println("Start file service");

        fileObj = new File(urlFile);

        if (fileObj.createNewFile()) {
            System.out.println("DB file create");
        } else {
            System.out.println("DB file exist");
        }
    }

    public EstudianteModel[] readDb() throws IOException {
        Scanner reader = new Scanner(fileObj);
        Path file = Paths.get(urlFile);
        int count = Integer.parseInt("" + Files.lines(file).count());
        EstudianteModel estudiantes[] = new EstudianteModel[count];
        int key = 0;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            List result = Arrays.asList(data.split("\\s*,\\s*"));

            estudiantes[key] = new EstudianteModel(
                    Integer.parseInt("" + result.get(0)),
                    result.get(1).toString(),
                    result.get(2).toString(),
                    result.get(3).toString(),
                    result.get(4).toString(),
                    Double.parseDouble("" + result.get(5)),
                    Double.parseDouble("" + result.get(6)),
                    Double.parseDouble("" + result.get(7)));
            key++;
        }

        return estudiantes;
    }
}
