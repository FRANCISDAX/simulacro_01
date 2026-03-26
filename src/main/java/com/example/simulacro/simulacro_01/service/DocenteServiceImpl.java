package com.example.simulacro.simulacro_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simulacro.simulacro_01.entity.Docente;
import com.example.simulacro.simulacro_01.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService{

    @Autowired
	private DocenteRepository docenteRepository;

    @Override
    public Docente registrarDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public List<Docente> listaDocentePorDni(String dni) {
        return docenteRepository.listaDocentePorDni(dni);
    }


}
