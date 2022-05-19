package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.EstudianteModel;

public class FileService {
    final String urlFile = "C:/app/data.csv";
    File fileObj;

    
    public FileService() throws IOException{
        System.out.println("Start file service");

        fileObj = new File(urlFile);

        if(fileObj.createNewFile()){
            System.out.println("DB file create");
        }else{
            System.out.println("DB file exist"); 
        }
    }

    public EstudianteModel[] readDb() throws IOException{
        Scanner reader = new Scanner(fileObj);
        Path file = Paths.get(urlFile);
        int count = Integer.parseInt(""+Files.lines(file).count()); 
        EstudianteModel estudiantes[] = new EstudianteModel[count];
        int key = 0;

        while(reader.hasNextLine()){
            String data = reader.nextLine();
            List result = Arrays.asList(data.split("\\s*,\\s*"));

            estudiantes[key] = new EstudianteModel(
                Integer.parseInt(""+result.get(0)), 
                result.get(1).toString(), 
                result.get(2).toString(), 
                result.get(3).toString(), 
                result.get(4).toString(), 
                Double.parseDouble(""+result.get(5)),
                Double.parseDouble(""+result.get(6)), 
                Double.parseDouble(""+result.get(7)) 
            );
            key++;
        }

        return estudiantes;
    }
}
