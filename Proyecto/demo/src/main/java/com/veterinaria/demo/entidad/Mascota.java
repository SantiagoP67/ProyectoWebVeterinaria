package com.veterinaria.demo.entidad;

public class Mascota {
    private Long id;
    private String nombre;
    private String raza;
    private int edad;
    private float peso;
    private String enfermedad;
    private String foto;
    private boolean activa;

    // Constructores
    public Mascota() {}

    public Mascota(Long id,String nombre, String raza, int edad, float peso, String enfermedad, String foto, boolean activa) {
        this.id=id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.foto = foto;
        this.activa = activa;
    }

    // Getters y Setters

    public Long getId() {return this.id;}

    public void setId(Long id) {this.id = id;}


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }

    public String getEnfermedad() { return enfermedad; }
    public void setEnfermedad(String enfermedad) { this.enfermedad = enfermedad; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}
