package TP1_Paradigmas.usuarios;

public class Usuario {
    private int n_legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String sexo;
    private int n_telefono;
    private int dni;


    public Usuario(int n_legajo, String nombre, String apellido,
    String email, String sexo, int n_telefono, int dni){
        this.n_legajo = n_legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.sexo = sexo;
        this.n_telefono = n_telefono;
        this.dni = dni;
    }

    public int getN_legajo() {
        return n_legajo;
    }

    public void setN_legajo(int n_legajo) {
        this.n_legajo = n_legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getN_telefono() {
        return n_telefono;
    }

    public void setN_telefono(int n_telefono) {
        this.n_telefono = n_telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
