package com.example.simulacro.simulacro_01.entity;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Entidad que representa un país")
@Entity
@Table(name="pais")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Pais implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Schema(description = "ID País", example = "173")
    private Long idPais;

    @Schema(description = "Abreviatura del País", example = "PE")
    private String iso;

    @Schema(description = "Nombre del País", example = "Perú")
    private String nombre;

}