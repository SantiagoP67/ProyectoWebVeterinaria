package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Servicio;
import com.veterinaria.demo.repositorio.ServicioRepository;
import com.veterinaria.demo.repositorio.TratamientoRepository;
import com.veterinaria.demo.repositorio.TratamientoMedicamentoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;
    private final TratamientoRepository tratamientoRepository;
    private final TratamientoMedicamentoRepository tratamientoMedicamentoRepository;

    // Constructor modificado para recibir los 3 repositorios
    public ServicioServiceImpl(ServicioRepository servicioRepository,
                             TratamientoRepository tratamientoRepository,
                             TratamientoMedicamentoRepository tratamientoMedicamentoRepository) {
        this.servicioRepository = servicioRepository;
        this.tratamientoRepository = tratamientoRepository;
        this.tratamientoMedicamentoRepository = tratamientoMedicamentoRepository;
    }

    @Override
    public List<Servicio> obtenerTodosServicios() {
        return servicioRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public BigDecimal calcularVentasTotales() {
        // 1. Sumar directamente el precio de venta de todos los medicamentos vendidos
        BigDecimal totalMedicamentos = tratamientoMedicamentoRepository.sumPrecioVentaMedicamentos();
        
        return totalMedicamentos != null ? totalMedicamentos : BigDecimal.ZERO;
    }
    
    @Override
    public BigDecimal calcularGananciasTotales() {
        // 1. Sumar ventas de medicamentos (como en calcularVentasTotales)
        BigDecimal ventasMedicamentos = this.calcularVentasTotales();
        
        // 2. Sumar precio base de TODOS los servicios (no solo los básicos)
        BigDecimal totalServicios = servicioRepository.sumPrecioBaseAllServicios();
        
        return ventasMedicamentos.add(totalServicios != null ? totalServicios : BigDecimal.ZERO);
    }
}