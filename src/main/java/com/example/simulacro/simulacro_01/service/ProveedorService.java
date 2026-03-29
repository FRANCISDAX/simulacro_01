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

    // 📋 Lista proveedores por estado (0 = inactivo, 1 = activo)
    List<Proveedor> listarPorEstado(Integer estado);

    // 🔎 Búsqueda por nombre (contiene texto, sin importar mayúsculas)
    List<Proveedor> buscarPorNombre(String nombre);

    // 🌐 Lista proveedores por tipo
    List<Proveedor> listarPorTipo(Long idTipo);

    // 🌍 Lista proveedores por país
    List<Proveedor> listarPorPais(Long idPais);
    
}
