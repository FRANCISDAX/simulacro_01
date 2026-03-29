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

    // 📋 Listar por estado
    @Operation(summary = "Listar proveedores por estado")
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Proveedor>> listarPorEstado(@PathVariable Integer estado) {
        log.info(">>> ListarPorEstado [INI] Estado: " + estado);
        List<Proveedor> lista = service.listarPorEstado(estado);
        log.info(">>> ListarPorEstado [FIN] Total: " + lista.size());
        return ResponseEntity.ok(lista);
    }

    // 🔎 Buscar por nombre
    @Operation(summary = "Buscar proveedores por nombre")
    @GetMapping("/buscar")
    public ResponseEntity<List<Proveedor>> buscarPorNombre(@RequestParam String nombre) {
        log.info(">>> BuscarPorNombre [INI] Nombre: " + nombre);
        List<Proveedor> lista = service.buscarPorNombre(nombre);
        log.info(">>> BuscarPorNombre [FIN] Total: " + lista.size());
        return ResponseEntity.ok(lista);
    }

    // 🌐 Listar por tipo
    @Operation(summary = "Listar proveedores por tipo")
    @GetMapping("/tipo/{idTipo}")
    public ResponseEntity<List<Proveedor>> listarPorTipo(@PathVariable Long idTipo) {
        log.info(">>> ListarPorTipo [INI] idTipo: " + idTipo);
        List<Proveedor> lista = service.listarPorTipo(idTipo);
        log.info(">>> ListarPorTipo [FIN] Total: " + lista.size());
        return ResponseEntity.ok(lista);
    }

    // 🌍 Listar por país
    @Operation(summary = "Listar proveedores por país")
    @GetMapping("/pais/{idPais}")
    public ResponseEntity<List<Proveedor>> listarPorPais(@PathVariable Long idPais) {
        log.info(">>> ListarPorPais [INI] idPais: " + idPais);
        List<Proveedor> lista = service.listarPorPais(idPais);
        log.info(">>> ListarPorPais [FIN] Total: " + lista.size());
        return ResponseEntity.ok(lista);
    }

}