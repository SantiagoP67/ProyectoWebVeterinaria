package com.veterinaria.demo.entidad;

public class Administrador {
    private int id;
    private String nombre;
    private int cedula;
    private String nombreUsuario;

    // Constructor vacío
    public Administrador() {
    }

    // Constructor con parámetros
    public Administrador(int id, String nombre, int cedula, String nombreUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.nombreUsuario = nombreUsuario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Método toString para representar el objeto como cadena
    @Override
    public String toString() {
        return "Administrador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
