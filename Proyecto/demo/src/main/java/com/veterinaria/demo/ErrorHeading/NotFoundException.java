package com.veterinaria.demo.ErrorHeading;

public class NotFoundException extends RuntimeException {
    private int id;

    public NotFoundException(int id, String message) {
        super(message);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
