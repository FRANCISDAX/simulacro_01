package com.example.simulacro.simulacro_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.simulacro.simulacro_01.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

    // 🔍 Verifica si ya existe un proveedor con ese nombre (ignorando mayúsculas/minúsculas).
    boolean existsByNombreIgnoreCase(String nombre);
    // 🔍 Verifica duplicado de nombre en UPDATE (excluye el mismo id).
    boolean existsByNombreAndIdProveedorNot(String nombre, Long idProveedor);
    // 🔍 Verifica si ya existe un proveedor con ese DNI.
    boolean existsByDni(String dni);
    // 🔍 Verifica duplicado de DNI en UPDATE (excluye el mismo id).
    boolean existsByDniAndIdProveedorNot(String dni, Long idProveedor);
    // 📋 Lista proveedores por estado (0 = inactivo, 1 = activo)
    List<Proveedor> findByEstado(Integer estado);
    // 🔎 Búsqueda por nombre (contiene texto, sin importar mayúsculas)
    List<Proveedor> findByNombreContainingIgnoreCase(String nombre);
    // 🌐 Lista proveedores por tipo (relación ManyToOne)
    List<Proveedor> findByTipo_IdTipo(Long idTipo);
    // 🌍 Lista proveedores por país (relación ManyToOne)
    List<Proveedor> findByPais_IdPais(Long idPais);
    // 🔤 Lista todos los proveedores ordenados por nombre ascendente
    @Query("SELECT p FROM Proveedor p JOIN FETCH p.tipo JOIN FETCH p.pais ORDER BY p.nombre ASC")
    List<Proveedor> listarConRelaciones();
     
}
