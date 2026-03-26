package com.example.simulacro.simulacro_01.service;

import java.util.List;

import com.example.simulacro.simulacro_01.entity.Docente;

public interface DocenteService {

    public abstract Docente registrarDocente(Docente docente);
	public abstract List<Docente> listaDocentePorDni(String dni);
    
}
