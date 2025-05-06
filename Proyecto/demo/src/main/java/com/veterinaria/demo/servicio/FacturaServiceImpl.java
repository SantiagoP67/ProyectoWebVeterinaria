package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.*;
import com.veterinaria.demo.repositorio.ClienteRepository;
import com.veterinaria.demo.repositorio.FacturaRepository;
import com.veterinaria.demo.repositorio.ServicioRepository;
import com.veterinaria.demo.repositorio.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Factura> obtenerTodasFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura obtenerFacturaPorID(Integer id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    @Override
    public Factura crearFacturaPorTratamiento(Integer idCliente, Integer idTratamiento, Factura factura) {
        float total = 0f;
        float totalMedicamentos = 0f;

        Tratamiento tratamiento = tratamientoRepository.findById(idTratamiento)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado"));


        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Servicio servicio = tratamiento.getServicio();
        if (servicio != null) {
            total += servicio.getPrecioBase();
            factura.setServicio(servicio);
        }

        // Calcular total por medicamentos
        List<TratamientoMedicamento> listaTratMed = tratamiento.getTratamientoMedicamentos();
        List<FacturaMedicamento> facturaMedicamentos = new ArrayList<>();

        Factura facturanueva = new Factura();

        for (TratamientoMedicamento tm : listaTratMed) {
            Medicamento med = tm.getMedicamento();
            int cantidad = tm.getCantidad();
            float subtotal = med.getPrecioVenta() * cantidad;
            totalMedicamentos += subtotal;

            // Crear entrada en FacturaMedicamento
            FacturaMedicamento fm = new FacturaMedicamento();
            fm.setMedicamento(med);
            fm.setFactura(facturanueva);
            facturaMedicamentos.add(fm);
        }

        total += totalMedicamentos;

        facturanueva.setFechaHora(factura.getFechaHora());
        facturanueva.setTotal(total);
        facturanueva.setPagada(factura.getPagada());
        facturanueva.setMetododepago(factura.getMetododepago());
        facturanueva.setCliente(cliente);
        facturanueva.setTratamiento(tratamiento);
        facturanueva.setServicio(servicio);
        facturanueva.setFacturaMedicamentos(facturaMedicamentos);

        facturaRepository.save(facturanueva);

        return facturanueva;
    }


}
