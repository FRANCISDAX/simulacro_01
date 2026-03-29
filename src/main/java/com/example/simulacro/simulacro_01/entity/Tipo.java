package com.example.simulacro.simulacro_01.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Entidad que representa un tipo de proveedor")
@Entity
@Table(name="tipo")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Tipo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Schema(description = "ID tipo de proveedor", example = "3")
    private Long idTipo;

    @Schema(description = "Descripción tipo de proveedor", example = "Local")
    private String descripcion;

}