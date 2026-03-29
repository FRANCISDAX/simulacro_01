package com.example.simulacro.simulacro_01.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.simulacro.simulacro_01.entity.Tipo;
import com.example.simulacro.simulacro_01.repository.TipoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoServiceImpl implements TipoService{

    private TipoRepository repo;

    // 📋 Listar todos.
    @Override
    public List<Tipo> listarTodos() {
        return repo.findAll();
    }

    // 🔍 Buscar por ID.
    @Override
    public Tipo buscarPorId(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo no encontrado"));    
    }

    // 💾 Guardar.
    @Override
    public Tipo guardar(Tipo tipo) {
        // 🔒 Validar nombre duplicado
        if(repo.existsByDescripcionIgnoreCase(tipo.getDescripcion())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tipo ya existe");
        }

        return repo.save(tipo);
    }

    // ✏️ Actualizar.
    @Override
    public Tipo actualizar(Long id, Tipo tipo) {
        Tipo existente = buscarPorId(id);

        // 🔒 Validar nombre duplicado (excluyendo el mismo registro)
        if(repo.existsByDescripcionAndIdTipoNot(tipo.getDescripcion(), id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tipo ya existe");
        }

        // ✏️ Actualizar campos
        existente.setDescripcion(tipo.getDescripcion());

        return repo.save(existente);
    }

    // 🗑️ Eliminar.
    @Override
    public void eliminar(Long id) {
        Tipo tipo = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo no encontrado"));

        repo.delete(tipo);
    }

}