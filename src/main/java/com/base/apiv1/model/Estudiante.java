package com.base.apiv1.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Estudiante {
    private int id; 
    private String nombre;
    private String apellido;
    private String carrera;
    private int edad;

    public Estudiante(int id, String nombre, String apellido, String carrera, int edad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.edad = edad;
    }  
    @JsonCreator 
    public Estudiante() {
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getCarrera() {
        return this.carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera; 
    }
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
