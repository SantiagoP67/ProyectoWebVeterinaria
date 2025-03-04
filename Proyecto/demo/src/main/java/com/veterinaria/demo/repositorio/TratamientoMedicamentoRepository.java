package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.TratamientoMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoMedicamentoRepository extends JpaRepository<TratamientoMedicamento, Long> {
}
