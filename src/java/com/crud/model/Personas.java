
package com.crud.model;

public class Personas {
    private int id, edad;
    private String nombre, telefono, correo;

    public Personas() {
    }

    public Personas(int edad, String nombre, String telefono, String correo) {
        this.edad = edad;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Personas(int id, int edad, String nombre, String telefono, String correo) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
