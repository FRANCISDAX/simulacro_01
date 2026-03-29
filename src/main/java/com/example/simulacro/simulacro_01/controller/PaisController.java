package com.example.simulacro.simulacro_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.simulacro.simulacro_01.entity.Pais;
import com.example.simulacro.simulacro_01.service.PaisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/api/paises")
@Tag(name = "Paises", description = "Operaciones sobre Paises")
public class PaisController {

    @Autowired
    private PaisService service;

    // 📋 Listar todos los paises.
    @Operation(summary = "Listar paises", description = "Obtiene todos los paises registrados")
    @GetMapping
    public ResponseEntity<List<Pais>> listar() {
        log.info(">>> ListaTodosLosPaises [INI]");
        List<Pais> lista = service.listarTodos();
        log.info(">>> ListaTodosLosPaises [FIN] - Total : " + lista.size());
        return ResponseEntity.ok(lista);
    }

    // 🔍 Buscar un país por ID.
    @Operation(summary = "Buscar un país por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Pais> buscarPorId(@PathVariable Long id) {
        log.info(">>> BuscarPaisPorId [INI] ID: " + id);
        Pais pais = service.buscarPorId(id);
        log.info(">>> BuscarPaisPorId [FIN] ID: " + id);
        return ResponseEntity.ok(pais);
    }

    // 💾 Registrar nuevo país.
    @Operation(summary = "Registrar un país")
    @PostMapping
    public ResponseEntity<Pais> guardar(@Valid @RequestBody Pais pais) {
        log.info(">>> RegistrarPais [INI] Nombre: " + pais.getNombre());
        Pais nuevo = service.guardar(pais);
        log.info(">>> RegistrarPais [FIN] ID generado: " + nuevo.getIdPais());
        return ResponseEntity.status(201).body(nuevo);
    }

    // ✏️ Actualizar un país existente.
    @Operation(summary = "Actualizar un país")
    @PutMapping("/{id}")
    public ResponseEntity<Pais> actualizar(@PathVariable Long id,
        @Valid @RequestBody Pais pais) {
        log.info(">>> ActualizarPais [INI] ID: " + id);
        Pais actualizado = service.actualizar(id, pais);
        log.info(">>> ActualizarPais [FIN] ID: " + id);
        return ResponseEntity.ok(actualizado);
    }

    // 🗑️ Eliminar un país.
    @Operation(summary = "Eliminar un país")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.info(">>> EliminarPais [INI] ID: " + id);
        service.eliminar(id);
        log.info(">>> EliminarPais [FIN] ID: " + id);
        return ResponseEntity.noContent().build();
    }

}