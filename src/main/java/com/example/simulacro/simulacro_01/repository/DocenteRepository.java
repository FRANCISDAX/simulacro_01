package com.example.simulacro.simulacro_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.simulacro.simulacro_01.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente,Integer>{

    @Query("select d from Docente d where d.dni = ?1")
	public List<Docente> listaDocentePorDni(String dni);
    
}
