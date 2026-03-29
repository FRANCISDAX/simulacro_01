package com.example.simulacro.simulacro_01.service;

import java.util.List;

import com.example.simulacro.simulacro_01.entity.Tipo;

public interface TipoService {

     // 📋 Obtiene la lista completa de tipos.
    List<Tipo> listarTodos();

    // 🔍 Busca un tipo por su ID.
    Tipo buscarPorId(Long id);

    // 💾 Registra un nuevo tipo.
    Tipo guardar(Tipo tipo);

    // ✏️ Actualiza un tipo existente.
    Tipo actualizar(Long id, Tipo tipo);

    // 🗑️ Elimina un tipo por su ID.
    void eliminar(Long id);
    
}
