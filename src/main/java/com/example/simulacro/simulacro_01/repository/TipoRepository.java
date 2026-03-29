package com.example.simulacro.simulacro_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simulacro.simulacro_01.entity.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long>{

    boolean existsByDescripcionIgnoreCase(String descripcion);
    boolean existsByDescripcionAndIdTipoNot(String descripcion, Long idTipo);

}
