package com.example.ejercicio2;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre;
    private String apellidos;
    private String matricula;
    private String genero;

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getGenero() {
        return genero;
    }

    public Alumno(String nombre, String apellidos, String matricula, String genero){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.matricula = matricula;
        this.genero = genero;
    }

}
