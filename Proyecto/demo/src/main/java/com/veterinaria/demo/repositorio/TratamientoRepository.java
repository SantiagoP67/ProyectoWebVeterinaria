package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
   /* public Tratamiento findById(int id){
        return data.get(id);
    }
    
    public Collection<Tratamiento> findAll(){
        return data.values(); 
    }*/
}