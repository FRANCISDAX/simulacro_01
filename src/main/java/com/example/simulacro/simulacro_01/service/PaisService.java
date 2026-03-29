package com.example.simulacro.simulacro_01.service;

import java.util.List;

import com.example.simulacro.simulacro_01.entity.Pais;

public interface PaisService {
    
    // 📋 Obtiene la lista completa de Paises.
    List<Pais> listarTodos();

    // 🔍 Busca un país por su ID.
    Pais buscarPorId(Long id);

    // 💾 Registra un nuevo país.
    Pais guardar(Pais pais);

    // ✏️ Actualiza un país existente.
    Pais actualizar(Long id, Pais pais);

    // 🗑️ Elimina un país por su ID.
    void eliminar(Long id);

}
