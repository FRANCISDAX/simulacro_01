package com.example.simulacro.simulacro_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simulacro.simulacro_01.entity.Docente;
import com.example.simulacro.simulacro_01.service.DocenteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/docente")
@Tag(name = "Docente", description = "Operaciones sobre docente")
public class DocenteController {

    @Autowired
	private DocenteService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<Docente> registrarDocente(@RequestBody Docente docente){
		log.info(">>> registrarDocente [ini] : " + docente);
		Docente obj = service.registrarDocente(docente);
		log.info(">>> registrarDocente [fin] : " + obj);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping("/porDni/{filtro}")
	public ResponseEntity<List<Docente>> listaDocentePorDni(@PathVariable("filtro") String parametro){
		log.info(">>> listaDocentePorDni [ini] : " + parametro);
		List<Docente> lista = service.listaDocentePorDni(parametro);
		log.info(">>> listaDocentePorDni [fin] : " + lista.size());
		return ResponseEntity.ok(lista);
	}
    
}
