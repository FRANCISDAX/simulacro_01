package com.example.simulacro.simulacro_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simulacro.simulacro_01.entity.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long>{

    // 🔍 Verifica si ya existe un tipo con ese nombre (ignorando mayúsculas/minúsculas).
    boolean existsByDescripcionIgnoreCase(String descripcion);
    // 🔍 Verifica duplicado de la descripción en UPDATE (excluye el mismo id).    
    boolean existsByDescripcionAndIdTipoNot(String descripcion, Long idTipo);

}