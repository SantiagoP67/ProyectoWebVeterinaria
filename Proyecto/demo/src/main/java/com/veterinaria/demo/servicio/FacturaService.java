package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Factura;
import com.veterinaria.demo.repositorio.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface FacturaService{
    Factura crearFacturaPorTratamiento(Integer idCliente, Integer idTratamiento, Factura factura);
    Factura crearFacturaPorServicio(Integer idCliente,Integer idServicio, Factura factura);
    Factura crearFacturaPorMedicamentos(Integer idCliente, List<Integer> idMedicamentos, Factura factura);
    Factura obtenerFacturaPorID(Integer id);
    List<Factura> obtenerTodasFacturas();
}
