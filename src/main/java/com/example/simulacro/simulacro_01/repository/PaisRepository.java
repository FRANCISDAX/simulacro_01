package com.example.simulacro.simulacro_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simulacro.simulacro_01.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
    boolean existsByNombreIgnoreCase(String nombre);
    boolean existsByNombreAndIdPaisNot(String nombre, Long idPais);

}
