package com.example.proyecto21042022;

import java.io.Serializable;

//Representación de una clase POJO (Plain Old Java Object)
public class Estudiante implements Serializable/*Interfaces marcador -> no hay que implementar reglas
                                                                        del juego*/
{

    //Atributos

    private String nombre;
    private String apellido;
    private int celular;
    private String email;
    private boolean estudiante;
    private int codigoEstudiante;

    //Constructor

    public Estudiante(String nombre, String apellido, int celular, String email, boolean estudiante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.estudiante = estudiante;
    }

    //Getters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCelular() {
        return celular;
    }

    public boolean isEstudiante() {
        return estudiante;
    }

    public String getEmail() {
        return email;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante\n" +
                "Nombre= " + nombre + '\n' +
                "Apellido= " + apellido + '\n' +
                "Celular= " + celular + '\n' +
                "Email= " + email + '\n' +
                "Es estudiante= " + estudiante + '\n' +
                "Código= " + codigoEstudiante;
    }
}
