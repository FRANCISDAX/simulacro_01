package com.example.simulacro.simulacro_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.simulacro.simulacro_01.entity.Proveedor;
import com.example.simulacro.simulacro_01.repository.ProveedorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    private ProveedorRepository repo;
    
    // 📋 Listar todos.
    @Override
    public List<Proveedor> listarTodos() {
        return repo.listarConRelaciones();
    }

    // 🔍 Buscar por ID.
    @Override
    public Proveedor buscarPorId(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));
    }

    // 💾 Guardar.
    @Override
    public Proveedor guardar(Proveedor proveedor) {
        // 🔒 Validar nombre duplicado
        if(repo.existsByNombreIgnoreCase(proveedor.getNombre())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre ya existe");
        }

        // 🔒 Validar DNI duplicado
        if(repo.existsByDni(proveedor.getDni())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El DNI ya existe");
        }

        return repo.save(proveedor);
    }

    // ✏️ Actualizar.
    @Override
    public Proveedor actualizar(Long id, Proveedor proveedor) {
        Proveedor existente = buscarPorId(id);

        // 🔒 Validar nombre duplicado (excluyendo el mismo registro)
        if(repo.existsByNombreAndIdProveedorNot(proveedor.getNombre(), id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre ya existe");
        }

        // 🔒 Validar DNI duplicado
        if(repo.existsByDniAndIdProveedorNot(proveedor.getDni(), id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El DNI ya existe");
        }

        // ✏️ Actualizar campos
        existente.setNombre(proveedor.getNombre());
        existente.setDni(proveedor.getDni());
        existente.setEstado(proveedor.getEstado());
        existente.setTipo(proveedor.getTipo());
        existente.setPais(proveedor.getPais());

        return repo.save(existente);
    }

    // 🗑️ Eliminar.
    @Override
    public void eliminar(Long id) {
        Proveedor proveedor = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));

        repo.delete(proveedor);
    }

    // 📋 Lista proveedores por estado (0 = inactivo, 1 = activo).
    @Override
    public List<Proveedor> listarPorEstado(Integer estado) {
        if(estado != 0 && estado != 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado inválido, solo 0 o 1");
        }
        return repo.findByEstado(estado);
    }

    // 🔎 Búsqueda por nombre (contiene texto, sin importar mayúsculas).
    @Override
    public List<Proveedor> buscarPorNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre);
    }

    // 🌐 Lista proveedores por tipo.
    @Override
    public List<Proveedor> listarPorTipo(Long idTipo) {
        return repo.findByTipo_IdTipo(idTipo);
    }

    // 🌍 Lista proveedores por país.
    @Override
    public List<Proveedor> listarPorPais(Long idPais) {
        return repo.findByPais_IdPais(idPais);
    }

}