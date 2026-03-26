package com.example.simulacro.simulacro_01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="ubigeo")
@Getter
@Setter
public class Ubigeo {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUbigeo;
	private String departamento;
	private String provincia;
	private String distrito;

}
