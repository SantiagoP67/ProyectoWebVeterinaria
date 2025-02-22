package com.veterinaria.demo.entidad;

// POJO
public class Tratamiento {
    private String fecha;
    private int id;

    public Tratamiento(String fecha, int id) {
        this.fecha = fecha;
        this.id = id;
    }

    // Getters y Setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
