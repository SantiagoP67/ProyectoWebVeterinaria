package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Factura;
import com.veterinaria.demo.servicio.FacturaService;
import com.veterinaria.demo.servicio.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factura")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;


    @GetMapping
    public List<Factura> ObtenerTodasFacturas() {
        return facturaService.obtenerTodasFacturas();
    }

    @GetMapping("/{id}")
    public Factura obtenerFacturaPorId(@PathVariable Integer id){
        return facturaService.obtenerFacturaPorID(id);
    }

    @PostMapping("/crear/tratamiento")
    public ResponseEntity<Factura> crearTratamiento(@RequestParam Integer idCliente,
                                                    @RequestParam Integer idTratamiento,
                                                    @RequestBody Factura factura){
        Factura guardada = facturaService.crearFacturaPorTratamiento(idCliente, idTratamiento, factura);
        return ResponseEntity.ok(guardada);
    }
}
