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
        return ResponseEntity.ok(service.listar());
    }

    // 🔍 Buscar proveedor por ID.
    @Operation(summary = "Buscar proveedor por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // 💾 Registrar nuevo proveedor.
    @Operation(summary = "Registrar proveedor")
    @PostMapping
    public ResponseEntity<Proveedor> guardar(@Valid @RequestBody Proveedor proveedor) {
        return ResponseEntity.status(201).body(service.guardar(proveedor));
    }

    // ✏️ Actualizar proveedor existente.
    @Operation(summary = "Actualizar proveedor")
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable Long id,
        @Valid @RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(service.actualizar(id, proveedor));
    }

    // 🗑️ Eliminar proveedor.
    @Operation(summary = "Eliminar proveedor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}