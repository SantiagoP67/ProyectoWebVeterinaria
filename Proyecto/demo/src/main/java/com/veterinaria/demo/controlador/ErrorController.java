package com.veterinaria.demo.controlador;

import org.springframework.web.bind.annotation.ControllerAdvice; 
import org.springframework.ui.model; 
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController{
    
   /* @ExceptionHandler (NotFoundException.class)
    public String error(Model model, NotFoundException ex){
        model.AddAtribute(attributeName: "id", ex.getId());
        return "inicio_sesion"; 
    }*/
}