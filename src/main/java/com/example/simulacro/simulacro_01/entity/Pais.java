package com.example.simulacro.simulacro_01.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pais")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Pais implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPais;
    private String iso;
    private String nombre;

}