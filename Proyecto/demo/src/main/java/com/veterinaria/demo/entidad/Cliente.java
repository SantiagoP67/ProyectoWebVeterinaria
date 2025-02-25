package com.veterinaria.demo.entidad;

public class Cliente {
    private int id;
    private String nombre;
    private int cedula;
    private String correo;
    private int celular;
    private String nombreUsuario;

    //Faltaria la lista de Mascotas
    //private List <Mascota> mascotas;

    // Constructor
    public Cliente(int id, String nombre, int cedula, String correo, int celular, String nombreUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.nombreUsuario = nombreUsuario;
    }
    //Constructor completo 
    /*   // Constructor
    public Cliente(int id, String nombre, int cedula, String correo, int celular, String nombreUsuario, List<Mascota> mascotas) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.nombreUsuario = nombreUsuario;
        this.mascotas = mascotas;
    } */

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

   /* public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }*/ 
}
