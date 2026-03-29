package com.example.simulacro.simulacro_01.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="proveedor")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Proveedor implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idProveedor;
    private String nombre;

    @Column(nullable=false,unique=true)
    private String dni;

    @NotNull
    @Min(0)
    @Max(1)
    private Integer estado;

    @Column(updatable=false)
    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idTipo")
    private Tipo tipo;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPais")
    private Pais pais;

}