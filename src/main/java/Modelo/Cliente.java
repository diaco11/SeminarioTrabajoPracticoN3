/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * TRABAJO PRACTICO N°3
 * ALUMNO: CRISTIAN DAVID DIACO
 * MATERIA: SEMINARIO PRACTICA INFORMATICA
 * 
 * MODULO CLIENTE
 */
public class Cliente {
    private int id;
    private String dni;
    private String nombre;
    private String telefono;
    private String direccion;
    private String razon;

    // CONSTRUCTORES
    public Cliente() {
    }

    public Cliente(int id, String dni, String nombre, String telefono, String direccion, String razon) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razon = razon;
    }

    
    // METODOS GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
