package com.example.simulacro.simulacro_01.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tipo")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Tipo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idTipo;
    private String descripcion;

}