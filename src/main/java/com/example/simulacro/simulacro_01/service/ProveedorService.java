package com.example.simulacro.simulacro_01.service;

import java.util.List;

import com.example.simulacro.simulacro_01.entity.Proveedor;

public interface ProveedorService {

    // 📋 Obtiene la lista completa de proveedores.
    List<Proveedor> listarTodos();

    // 🔍 Busca un proveedor por su ID.
    Proveedor buscarPorId(Long id);

    // 💾 Registra un nuevo proveedor.
    Proveedor guardar(Proveedor proveedor);

    // ✏️ Actualiza un proveedor existente.
    Proveedor actualizar(Long id, Proveedor proveedor);

    // 🗑️ Elimina un proveedor por su ID.
    void eliminar(Long id);
    
}
