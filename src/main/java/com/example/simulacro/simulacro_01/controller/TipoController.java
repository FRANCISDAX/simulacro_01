package com.example.simulacro.simulacro_01.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.apachecommons.CommonsLog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.simulacro.simulacro_01.entity.Tipo;
import com.example.simulacro.simulacro_01.service.TipoService;


@CommonsLog
@RestController
@RequestMapping("/api/tipos")
@Tag(name = "Tipos", description = "Operaciones sobre Tipos de Proveedores")
public class TipoController {

    @Autowired
    private TipoService service;

    // 📋 Listar todos los tipos de proveedores.
    @Operation(summary = "Listar tipos de proveedores", description = "Obtiene todos los tipos de  proveedores registrados")
    @GetMapping
    public ResponseEntity<List<Tipo>> listar() {
        log.info(">>> ListaTodosLosTiposDeProveedores [INI]");
        List<Tipo> lista = service.listarTodos();
        log.info(">>> ListaTodosLosTiposDeProveedores [FIN] - Total : " + lista.size());
        return ResponseEntity.ok(lista);
    }

    // 🔍 Buscar tipo de proveedor por ID.
    @Operation(summary = "Buscar tipo de proveedor por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Tipo> buscarPorId(@PathVariable Long id) {
        log.info(">>> BuscarTipoPorId [INI] ID: " + id);
        Tipo tipo = service.buscarPorId(id);
        log.info(">>> BuscarTipoPorId [FIN] ID: " + id);
        return ResponseEntity.ok(tipo);
    }

    // 💾 Registrar nuevo tipo de proveedor.
    @Operation(summary = "Registrar tipo de proveedor")
    @PostMapping
    public ResponseEntity<Tipo> guardar(@Valid @RequestBody Tipo tipo) {
        log.info(">>> RegistrarTipo [INI] Nombre: " + tipo.getDescripcion());
        Tipo nuevo = service.guardar(tipo);
        log.info(">>> RegistrarTipo [FIN] ID generado: " + nuevo.getIdTipo());
        return ResponseEntity.status(201).body(nuevo);
    }

    // ✏️ Actualizar tipo de proveedor existente.
    @Operation(summary = "Actualizar tipo de proveedor")
    @PutMapping("/{id}")
    public ResponseEntity<Tipo> actualizar(@PathVariable Long id,
        @Valid @RequestBody Tipo tipo) {
        log.info(">>> ActualizarTipo [INI] ID: " + id);
        Tipo actualizado = service.actualizar(id, tipo);
        log.info(">>> ActualizarTipo [FIN] ID: " + id);
        return ResponseEntity.ok(actualizado);
    }

    // 🗑️ Eliminar tipo de proveedor.
    @Operation(summary = "Eliminar tipo de proveedor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.info(">>> EliminarTipo [INI] ID: " + id);
        service.eliminar(id);
        log.info(">>> EliminarTipo [FIN] ID: " + id);
        return ResponseEntity.noContent().build();
    }

}