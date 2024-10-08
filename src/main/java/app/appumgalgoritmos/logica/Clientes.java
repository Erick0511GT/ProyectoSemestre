/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.appumgalgoritmos.logica;

/**
 *
 * @author Erick Hernandez
 */
public class Clientes {
    private int DPi;
    private String Nombre;
    private String Apellido;
    private String Genero;
    private int Edad;
    private String Profesion;

    public Clientes(int DPi, String Nombre, String Apellido, String Genero, int Edad, String Profesion) {
        this.DPi = DPi;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Genero = Genero;
        this.Edad = Edad;
        this.Profesion = Profesion;
    }

    public int getDPi() {
        return DPi;
    }

    public void setDPi(int DPi) {
        this.DPi = DPi;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }
    
    
            
    
}
