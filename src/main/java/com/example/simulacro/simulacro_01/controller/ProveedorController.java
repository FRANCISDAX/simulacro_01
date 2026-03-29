package com.example.simulacro.simulacro_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.simulacro.simulacro_01.entity.Proveedor;
import com.example.simulacro.simulacro_01.service.ProveedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/api/proveedores")
@Tag(name = "Proveedores", description = "Operaciones sobre Proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService service;

    // 📋 Listar todos los proveedores.
    @Operation(summary = "Listar proveedores", description = "Obtiene todos los proveedores registrados")
    @GetMapping
    public ResponseEntity<List<Proveedor>> listar() {
        log.info(">>> ListaTodosLosProveedores [INI]");
        List<Proveedor> lista = service.listarTodos();
        log.info(">>> ListaTodosLosProveedores [FIN] - Total : " + lista.size());
        return ResponseEntity.ok(lista);
    }

    // 🔍 Buscar proveedor por ID.
    @Operation(summary = "Buscar proveedor por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> buscarPorId(@PathVariable Long id) {
        log.info(">>> BuscarProveedorPorId [INI] ID: " + id);
        Proveedor proveedor = service.buscarPorId(id);
        log.info(">>> BuscarProveedorPorId [FIN] ID: " + id);
        return ResponseEntity.ok(proveedor);
    }

    // 💾 Registrar nuevo proveedor.
    @Operation(summary = "Registrar proveedor")
    @PostMapping
    public ResponseEntity<Proveedor> guardar(@Valid @RequestBody Proveedor proveedor) {
        log.info(">>> RegistrarProveedor [INI] Nombre: " + proveedor.getNombre());
        Proveedor nuevo = service.guardar(proveedor);
        log.info(">>> RegistrarProveedor [FIN] ID generado: " + nuevo.getIdProveedor());
        return ResponseEntity.status(201).body(nuevo);
    }

    // ✏️ Actualizar proveedor existente.
    @Operation(summary = "Actualizar proveedor")
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable Long id,
        @Valid @RequestBody Proveedor proveedor) {
        log.info(">>> ActualizarProveedor [INI] ID: " + id);
        Proveedor actualizado = service.actualizar(id, proveedor);
        log.info(">>> ActualizarProveedor [FIN] ID: " + id);
        return ResponseEntity.ok(actualizado);
    }

    // 🗑️ Eliminar proveedor.
    @Operation(summary = "Eliminar proveedor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.info(">>> EliminarProveedor [INI] ID: " + id);
        service.eliminar(id);
        log.info(">>> EliminarProveedor [FIN] ID: " + id);
        return ResponseEntity.noContent().build();
    }

}