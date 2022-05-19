package models;

public class UserModel{
    private int id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    private String pass;
    private String username;

    public UserModel(int id,String firstName,String secondName,String FirsLastName,String secondLastName){
        this(id,firstName, secondName, FirsLastName, secondLastName, "", "");
    }

    public UserModel(int id,String firstName,String secondName,String FirsLastName,String secondLastName,String userName,String pass){
        this.id = id;
        this.primerNombre = firstName;
        this.segundoNombre = secondName;
        this.primerApellido = FirsLastName;
        this.segundoApellido = secondLastName;
        this.username = userName;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }
    public String getPrimerNombre() {
        return primerNombre;
    }
    public String getSegundoNombre() {
        return segundoNombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
}