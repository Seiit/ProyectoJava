package models;

import services.ScoreService;

public class EstudianteModel extends UserModel {
    public EstudianteModel(int id, String firstName, String secondName, String FirsLastName, String secondLastName,double nota1,double nota2,double nota3) {
        super(id, firstName, secondName, FirsLastName, secondLastName);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.setNotaFinal();
    }

    private ScoreService score = new ScoreService<>();

    private double nota1 = 0;
    private double nota2 = 0;
    private double nota3 = 0;
    private double notaFinal;

    public void setNotaFinal() {
        this.notaFinal = (Double)score.calculateScore(nota1, nota2, nota3);
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNotaFInal(){
        return this.notaFinal;
    }
    public double getNota1() {
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getNota3() {
        return nota3;
    }
}
