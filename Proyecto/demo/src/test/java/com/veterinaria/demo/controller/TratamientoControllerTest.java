package com.veterinaria.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.veterinaria.demo.controlador.TratamientoController;
import com.veterinaria.demo.servicio.TratamientoService;

@WebMvcTest(controllers = TratamientoController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class TratamientoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TratamientoService tratamientoService;

    @Test
    public void TratamientoController_crearTratamiento_Tratamiento(){
        mockMvc.perform().andExpect();
    }
}