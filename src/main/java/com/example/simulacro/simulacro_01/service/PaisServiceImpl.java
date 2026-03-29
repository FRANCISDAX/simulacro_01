package com.example.simulacro.simulacro_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.simulacro.simulacro_01.entity.Pais;
import com.example.simulacro.simulacro_01.entity.Tipo;
import com.example.simulacro.simulacro_01.repository.PaisRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaisServiceImpl implements PaisService{

    @Autowired
    private PaisRepository repo;

    // 📋 Listar todos.
    @Override
    public List<Pais> listarTodos() {
        return repo.findAll();
    }

    // 🔍 Buscar por ID.
    @Override
    public Pais buscarPorId(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País no encontrado"));
    }

    // 💾 Guardar.
    @Override
    public Pais guardar(Pais pais) {
        // 🔒 Validar nombre duplicado
        if(repo.existsByNombreIgnoreCase(pais.getNombre())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El país ya existe");
        }

        return repo.save(pais);
    }

    // ✏️ Actualizar.
    @Override
    public Pais actualizar(Long id, Pais pais) {
        Pais existente = buscarPorId(id);

        // 🔒 Validar nombre duplicado (excluyendo el mismo registro)
        if(repo.existsByNombreAndIdPaisNot(pais.getNombre(), id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El país ya existe");
        }

        // ✏️ Actualizar campos
        existente.setIso(pais.getIso());
        existente.setNombre(pais.getNombre());

        return repo.save(existente);
    }

    // 🗑️ Eliminar.
    @Override
    public void eliminar(Long id) {
        Pais pais = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País no encontrado"));

        repo.delete(pais);    }

    }